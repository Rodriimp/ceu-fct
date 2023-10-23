package proyecto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208104002946207287L;

	private List<String> columnas;

	public TableModel() {
		columnas = new ArrayList<String>();
		columnas.add("Fecha");
		columnas.add("Horas");
		columnas.add("Tareas");
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public int getColumnCount() {
		return columnas.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnas.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
