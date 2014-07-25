package Cal;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

public class CalCellEditor implements TableCellEditor {
	protected JLabel button;
	private String label;
	private boolean isPushed;
	JTable table;
	int row;
	int column;

	public CalCellEditor(JCheckBox checkBox) {
		super();
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// button = new JLabel();
		// button.setOpaque(true);
		// button.addMouseListener();

		/*
		 * .addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { fireEditingStopped(); } });
		 */
		// label = (value ==null) ? "" : value.toString();
		// button.setText( label );
		isPushed = false;
		// this.addCellEditorListener();
		/*
		 * button.addMouseListener(new java.awt.event.MouseAdapter() { public
		 * void mouseReleased(MouseEvent e) { cs_00_mouseReleased(e); } });
		 */
		return null;// table.getComponentAt(row,0);
	}

	void cs_00_mouseReleased(MouseEvent e) {

	}

	public Object getCellEditorValue() {
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		/*
		 * System.out.println("stopCellEditing"); isPushed = false; return
		 * super.stopCellEditing();
		 */
		return true;
	}

	protected void fireEditingStopped() {
		// super.fireEditingStopped();
//		super.fireEditingCanceled();
	}

	@Override
	public void addCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCellEditable(EventObject arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSelectCell(EventObject arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
