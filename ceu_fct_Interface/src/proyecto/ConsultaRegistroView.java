package proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
		scrollPane.setBounds(48, 28, 505, 374);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		TableModel model = new TableModel();
		table.setModel(model);

		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setBounds(477, 422, 113, 23);
		add(btnRefrescar);
		btnRefrescar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRegistros(appControler.consultarRegistros());
				model.fireTableDataChanged();
			}
		});
	}
}
