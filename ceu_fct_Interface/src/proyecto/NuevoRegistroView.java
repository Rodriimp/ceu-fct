package proyecto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import proyecto.modelo.Registro;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextArea;

public class NuevoRegistroView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1800565692864282734L;

	public NuevoRegistroView(App appControler) {
		super(appControler);
		setLayout(null);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(87, 67, 46, 14);
		add(lblFecha);

		JLabel lblNumHoras = new JLabel("0");
		lblNumHoras.setForeground(Color.RED);
		lblNumHoras.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumHoras.setBounds(419, 158, 34, 14);
		add(lblNumHoras);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(87, 92, 214, 22);
		add(comboBox);
		List<String> listafechas = appControler.fechas();
		for (String fecha : listafechas) {
			comboBox.addItem(fecha);
		}

		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(16);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setBounds(84, 148, 325, 52);
		add(slider);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				BigDecimal valor = new BigDecimal(slider.getValue()).divide(new BigDecimal(2));

				lblNumHoras.setText(String.valueOf(valor));
			}
		});

		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(87, 133, 46, 14);
		add(lblHoras);

		JLabel lblTareas = new JLabel("Tareas realizadas:");
		lblTareas.setBounds(127, 245, 107, 14);
		add(lblTareas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 270, 271, 88);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(486, 398, 89, 23);
		add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Registro r = new Registro();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fecha = LocalDate.parse(comboBox.getSelectedItem().toString(), formato);
				r.setFecha(java.sql.Date.valueOf(fecha));
				r.setId_usuario(appControler.getUsuarioConectado().getId_usuario());
				r.setNum_horas(new BigDecimal(slider.getValue()));
				r.setDescripcion(textArea.getText());

				appControler.crearNuevoRegistro(r);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(585, 398, 89, 23);
		add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appControler.irAPantallaBienvenida();
			}
		});

	}
}
