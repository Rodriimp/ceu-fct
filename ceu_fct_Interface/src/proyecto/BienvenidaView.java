package proyecto;
import javax.swing.JLabel;

import proyecto.modelo.Usuario;


public class BienvenidaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6598183554631491391L;

	public BienvenidaView(App appControler, Usuario u) {
		super(appControler);
		setLayout(null);
		
		JLabel lblCentro = new JLabel("Hola " + appControler.getUsuarioConectado().getNombre());
		lblCentro.setBounds(181, 141, 72, 14);
		add(lblCentro);
		
	
		
	}
}
