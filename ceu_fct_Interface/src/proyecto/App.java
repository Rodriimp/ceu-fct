package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	private JFrame frame;
	private LoginView loginPantalla;

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
		
		irAPantallaLogin();

	}
	
	public void irAPantallaLogin() {
		frame.setContentPane(loginPantalla);
		frame.revalidate();
	}

}
