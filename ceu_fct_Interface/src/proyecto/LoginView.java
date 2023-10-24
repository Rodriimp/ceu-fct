package proyecto;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2250983659191714033L;
	private JTextField textField_email;
	private JPasswordField passwordField;

	public LoginView(App appControler) {
		super(appControler);
		setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(265, 155, 56, 14);
		add(lblEmail);

		textField_email = new JTextField();
		textField_email.setBounds(265, 170, 139, 20);
		add(textField_email);
		textField_email.setColumns(10);
		textField_email.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_ENTER) {
					e.getComponent().transferFocus();
				}
			}
		});

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(265, 201, 77, 14);
		add(lblContraseña);

		passwordField = new JPasswordField();
		passwordField.setBounds(265, 218, 139, 20);
		add(passwordField);

		passwordField.addKeyListener(new KeyListener() {

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
					appControler.login(textField_email.getText(), passwordField.getPassword());

				}
			}
		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(315, 250, 89, 23);
		add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appControler.login(textField_email.getText(), passwordField.getPassword());
			}
		});

		JButton btnAcceso = new JButton("Solicitar acceso");
		btnAcceso.setBounds(352, 404, 133, 23);
		add(btnAcceso);
		btnAcceso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appControler.irAPantallaSolicitar();
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(495, 404, 89, 23);
		add(btnSalir);

	}
}
