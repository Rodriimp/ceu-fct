package proyecto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import proyecto.modelo.Fecha;
import proyecto.modelo.Registro;
import proyecto.modelo.Usuario;
import proyecto.services.AutenticarException;
import proyecto.services.FctException;
import proyecto.services.FechasService;
import proyecto.services.RegistrosService;
import proyecto.services.UsuariosService;

public class App {

	private JFrame frame;
	private JMenuBar menuBar;
	private LoginView loginPantalla;
	private BienvenidaView bienvenidaPantalla;
	private NuevoRegistroView newRegistroPantalla;
	private ConsultaRegistroView consultaRegistroPantalla;
	private SolicitarAccesoView solicitarAccesoPantalla;
	private Usuario usuarioConectado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginPantalla = new LoginView(this);
		solicitarAccesoPantalla = new SolicitarAccesoView(this);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 734, 22);
		frame.setJMenuBar(menuBar);
		;

		JMenu mnApp = new JMenu("App");
		menuBar.add(mnApp);

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mnApp.add(mntmCerrarSesion);
		mntmCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cerrando Sesión...", "System", JOptionPane.INFORMATION_MESSAGE);
				irAPantallaLogin();
				
			}
		});

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnApp.add(mntmSalir);
		mntmSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenu mnRegistros = new JMenu("Registros");
		menuBar.add(mnRegistros);

		JMenuItem mntmNuevoRegistro = new JMenuItem("Crear nuevo registro");
		mnRegistros.add(mntmNuevoRegistro);
		mntmNuevoRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantallaNuevoRegistro();
			}
		});

		JMenuItem mntmConsultarRegistro = new JMenuItem("Consultar registros");
		mnRegistros.add(mntmConsultarRegistro);
		mntmConsultarRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantallaConsulta();
			}
		});

		irAPantallaLogin();

	}

	public void irAPantallaLogin() {
		frame.setContentPane(loginPantalla);
		menuBar.setVisible(true);
		frame.revalidate();
	}

	public void irAPantallaNuevoRegistro() {
		menuBar.setVisible(true);
		newRegistroPantalla = new NuevoRegistroView(this);
		frame.setContentPane(newRegistroPantalla);
		frame.revalidate();
	}

	public void irAPantallaBienvenida() {
		bienvenidaPantalla = new BienvenidaView(this, usuarioConectado);
		frame.setContentPane(bienvenidaPantalla);
		menuBar.setVisible(true);
		frame.revalidate();
	}

	public void irAPantallaConsulta() {
		menuBar.setVisible(true);
		consultaRegistroPantalla = new ConsultaRegistroView(this);
		frame.setContentPane(consultaRegistroPantalla);
		frame.revalidate();
	}

	public void irAPantallaSolicitar() {
		frame.setContentPane(solicitarAccesoPantalla);
		menuBar.setVisible(false);
		frame.revalidate();
	}

	public void setUsuarioConectado(Usuario u) {
		this.usuarioConectado = u;
	}

	public Usuario getUsuarioConectado() {
		return usuarioConectado;
	}

	public void login(String email, char[] cs) {
		UsuariosService uService = new UsuariosService();
		Usuario u = new Usuario();
		try {
			String pass = String.valueOf(cs);
			u = uService.login(email, pass);

		} catch (FctException | AutenticarException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		setUsuarioConectado(u);

		irAPantallaBienvenida();
	}

	public void solicitarAcceso(Usuario u) {
		UsuariosService uService = new UsuariosService();
		u.setActivo(true);

		try {
			uService.altaUsuario(u);

		} catch (FctException e) {
			e.printStackTrace();
		}

		setUsuarioConectado(u);

		irAPantallaLogin();
	}

	public void crearNuevoRegistro(Registro r) {
		RegistrosService rService = new RegistrosService();

		try {
			rService.crearRegistro(r);
			JOptionPane.showMessageDialog(null, "¡Registro creado con éxito!", "System",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (FctException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<String> fechas() {

		FechasService fService = new FechasService();
		List<Fecha> fechas = new ArrayList<Fecha>();
		List<String> listaString = new ArrayList<String>();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			fechas = fService.consultarActuales();
			for (Fecha f : fechas) {
				listaString.add(formato.format(f.getFecha()));
			}

		} catch (FctException e) {
			e.printStackTrace();
		}
		return listaString;

	}

	public List<Registro> consultarRegistros() {
		
		RegistrosService rS = new RegistrosService();
		List<Registro> registros = new ArrayList<Registro>();
		try {
			registros = rS.consultarRegistrosUsuario(usuarioConectado.getId_usuario());
		} catch (FctException e) {
			e.printStackTrace();
		}
		return registros;
	}

}
