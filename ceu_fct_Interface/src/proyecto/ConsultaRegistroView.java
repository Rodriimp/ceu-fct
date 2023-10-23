package proyecto;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConsultaRegistroView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278715078504329395L;
	private JTable table;

	public ConsultaRegistroView(App appControler) {
		super(appControler);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 37, 356, 232);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
