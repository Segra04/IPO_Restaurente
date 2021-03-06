package presentacion;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MiTablaPedidos extends AbstractTableModel {

	private String[] nombreColumnas = { "Id", "Cliente", "Dirección", "Telefono", "Platos", "Fecha",
			"Fecha de recogida" };
	// Quizas mas cosas en plan precio, lista platos y demás
	private Vector datos = new Vector();

	public int getColumnCount() {
		return nombreColumnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}

	public String getColumnName(int col) {
		return nombreColumnas[col];
	}

	public Object getValueAt(int row, int col) {
		Object[] fila = (Object[]) datos.elementAt(row);
		return fila[col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void setValueAt(Object value, int row, int col) {
		if (row < getRowCount() && col < getColumnCount()) {
			Object[] fila = (Object[]) datos.elementAt(row);
			fila[col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	public void eliminaFila(int row) {
		datos.remove(row);
	}

	public void aniadeFila(Object[] row) {
		datos.add(row);
	}

	public String getDescripcion(int row) {
		String descripcion = null;
		Object[] fila = (Object[]) datos.elementAt(row);
		descripcion = (String) fila[2];
		return descripcion;
	}

}
