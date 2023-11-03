package proyecto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import proyecto.modelo.Registro;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208104002946207287L;

	private List<Registro> registros;
	private List<String> columnas;

	public TableModel() {
		registros = new ArrayList<Registro>();
		columnas = new ArrayList<String>();
		columnas.add("Fecha");
		columnas.add("Horas");
		columnas.add("Tareas");
	}

	@Override
	public int getRowCount() {
		return registros.size();
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
		Registro r = registros.get(rowIndex);
		String nombreCol = columnas.get(columnIndex);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaCadena = formato.format(r.getFecha().toLocalDate());

		if (nombreCol.equals("Fecha")) {
			return fechaCadena;
		}
		if (nombreCol.equals("Horas")) {
			return r.getNum_horas();
		}
		if (nombreCol.equals("Tareas")) {
			return r.getDescripcion();
		}
		return "ERROR";
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<String> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

}
