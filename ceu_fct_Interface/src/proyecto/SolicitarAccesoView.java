package proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import proyecto.modelo.Usuario;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class SolicitarAccesoView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1867076631229565863L;
	private JTextField textField_email;
	private JTextField textField_nombre;
	private JTextField textField_apellidos;
	private JPasswordField passwordField;
	private JPasswordField passwordField_repe;

	public SolicitarAccesoView(App appControler) {
		super(appControler);
		setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(286, 104, 46, 14);
		add(lblEmail);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContraseña.setBounds(286, 154, 79, 14);
		add(lblContraseña);

		passwordField = new JPasswordField();
		passwordField.setBounds(286, 174, 166, 20);
		add(passwordField);

		JLabel lblRepetirContra = new JLabel("Repetir Contraseña:");
		lblRepetirContra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepetirContra.setBounds(286, 205, 117, 14);
		add(lblRepetirContra);

		passwordField_repe = new JPasswordField();
		passwordField_repe.setBounds(286, 223, 166, 20);
		add(passwordField_repe);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(286, 254, 68, 14);
		add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(286, 306, 79, 14);
		add(lblApellidos);

		JLabel lblCiclo = new JLabel("Ciclo formativo: ");
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCiclo.setBounds(286, 357, 104, 14);
		add(lblCiclo);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(286, 384, 166, 22);
		add(comboBox);
		comboBox.addItem("DAM");
		comboBox.addItem("DAW");
		comboBox.addItem("ASIR");
		comboBox.setSelectedItem(null);

		textField_email = new JTextField();
		textField_email.setBounds(286, 123, 166, 20);
		add(textField_email);
		textField_email.setColumns(10);

		textField_nombre = new JTextField();
		textField_nombre.setBounds(286, 275, 166, 20);
		add(textField_nombre);
		textField_nombre.setColumns(10);

		textField_apellidos = new JTextField();
		textField_apellidos.setBounds(286, 326, 166, 20);
		add(textField_apellidos);
		textField_apellidos.setColumns(10);

		KeyListener kL = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_ENTER) {
					e.getComponent().transferFocus();
				}
			}
		};
		textField_email.addKeyListener(kL);
		textField_nombre.addKeyListener(kL);
		textField_apellidos.addKeyListener(kL);
		passwordField.addKeyListener(kL);
		passwordField_repe.addKeyListener(kL);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(495, 496, 89, 23);
		add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();

				String password = new String(passwordField.getPassword());
				String password2 = new String(passwordField_repe.getPassword());

				if (password.equals(password2) && !password.isEmpty() && !password2.isEmpty()
						&& comboBox.getSelectedItem() != null && !textField_email.getText().isEmpty()
						&& !textField_nombre.getText().isEmpty() && !textField_apellidos.getText().isEmpty()
						&& !textField_apellidos.getText().isEmpty()) {

					u.setEmail(textField_email.getText());
					u.setPassword(password);
					u.setCiclo(comboBox.getSelectedItem().toString());
					u.setNombre(textField_nombre.getText());
					u.setApellidos(textField_apellidos.getText());
					JOptionPane.showMessageDialog(null, "¡Usuario creado con éxito!", null,
							JOptionPane.INFORMATION_MESSAGE);
					appControler.solicitarAcceso(u);

				}

				else if (!password.equals(password2)) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Los campos deben estar completos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(594, 496, 89, 23);
		add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appControler.irAPantallaLogin();
			}
		});

	}
}
