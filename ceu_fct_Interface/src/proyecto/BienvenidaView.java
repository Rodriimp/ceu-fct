package proyecto;
import javax.swing.JLabel;

import proyecto.modelo.Usuario;
import java.awt.Font;


public class BienvenidaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6598183554631491391L;

	public BienvenidaView(App appControler, Usuario u) {
		super(appControler);
		setLayout(null);
		
		JLabel lblCentro = new JLabel("Hola " + u.getNombre());
		lblCentro.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblCentro.setBounds(295, 181, 290, 120);
		add(lblCentro);
		
	
		
	}
}
