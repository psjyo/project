package Cal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class CalCellRenderer extends JLabel implements TableCellRenderer {
	URL u_img;
	public Image bgImage;
	public CalGUI frame;
	String yy;
	String mm;
//	DBQuery dbq;
	String curDate;
	String spinYear;
	String month;
	String daytmp;
	Font boldFont;
	Connection con = null;

	public CalCellRenderer(CalGUI frame, String curDate) {
		setOpaque(true);
		this.frame = frame;
		this.curDate = curDate;
		spinYear = frame.getSpinnerYear() + "";
		month = frame.getMonth() + "";
		if (month.length() == 1)
			month = "0" + month;
//		dbq = new DBQuery();
//		con = new DBCon().getConnection();
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected && table.getSelectedColumn() == column
				&& table.getSelectedRow() == row && !value.equals("")) {
			setForeground(Color.white);
			setBackground(Color.lightGray);

		} else {
			setForeground(UIManager.getColor(Color.green));
			setBackground(UIManager.getColor(Color.green));
		}
		if (column == 0) { // 일요일
			setForeground(Color.RED);
		} else if (column == 6) { // 토요일
			setForeground(Color.BLUE);
		}
		if (diaryCheck(table.getValueAt(row, column).toString())) {
			setForeground(Color.CYAN);
			// setBackground(Color.yellow);
		}
		daytmp = (value.toString().length() == 1) ? "0" + value : value
				.toString();

		if (curDate.equals((spinYear + month + daytmp))) {
			boldFont = this.getFont();
			new Font(boldFont.getName(), Font.BOLD, 10);
			setForeground(Color.MAGENTA); // 오늘
		}
		setText((value == null) ? "" : value.toString());
		this.setHorizontalAlignment(SwingConstants.CENTER);
		return this;
	}

	public boolean diaryCheck(String value) {
		if (value == null || value.equals(""))
			return false;
		yy = frame.getSpinnerYear() + "";
		mm = frame.getMonth() + "";
		if (mm.length() == 1)
			mm = "0" + mm;
		if (value.length() == 1)
			value = "0" + value;
//		return dbq.existMessage(yy + "-" + mm + "-" + value);
		return false;
	}

}
