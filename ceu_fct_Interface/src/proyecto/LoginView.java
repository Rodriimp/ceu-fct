package proyecto;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2250983659191714033L;
	private JTextField textField;
	private JTextField textField_1;

	public LoginView(App appControler) {
		super(appControler);
		setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(265, 155, 56, 14);
		add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(265, 170, 139, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(265, 201, 77, 14);
		add(lblContraseña);
		
		textField_1 = new JTextField();
		textField_1.setBounds(265, 219, 139, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(315, 250, 89, 23);
		add(btnEntrar);
		
		JButton btnAcceso = new JButton("Solicitar acceso");
		btnAcceso.setBounds(352, 404, 133, 23);
		add(btnAcceso);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(495, 404, 89, 23);
		add(btnSalir);
		
	}
}
