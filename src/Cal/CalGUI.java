package Cal;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class CalGUI extends JPanel implements ActionListener {
	private JFrame frame;
	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();
	private JTable jTable1;
	private JPanel jPanel1 = new JPanel();
	private JLabel jLabel1 = new JLabel();
	private DefaultTableModel dm;
	private JScrollPane jScrollPane1;
	private JSpinner spinner = new JSpinner();
	SpinnerDateModel dateModel;
	private GridLayout gridLayout1 = new GridLayout();
	private JComboBox jComboBox1 = new JComboBox();
	private JLabel jLabel2 = new JLabel();
	int Today_Y;
	int Today_M;
	int Today_D;
	public static CalGUI frmain = null;
	private JButton btnadd;
	private JTextArea tacontent;
	private JLabel titlelabel;
	private JLabel contentlabel;
	private JLabel datelabel;
	private JLabel datelabel2;
	private JTextField tftitle;
	private JButton btndel;
	private JButton btnclose;
	// Construct the frame
	// MemoDialog memo;
	String curDate;

	public void CalMemo() {

		btnadd = new JButton("\uCD94\uAC00");
		btnadd.setBounds(44, 289, 70, 23);
		frame.getContentPane().add(btnadd);

		tacontent = new JTextArea();
		tacontent.setBounds(44, 81, 251, 179);
		frame.getContentPane().add(tacontent);

		titlelabel = new JLabel("\uC81C\uBAA9");
		titlelabel.setBounds(34, 10, 57, 15);
		frame.getContentPane().add(titlelabel);

		contentlabel = new JLabel("\uB0B4\uC6A9");
		contentlabel.setBounds(34, 56, 57, 15);
		frame.getContentPane().add(contentlabel);
		
		datelabel = new JLabel("\uB0A0\uC9DC");
		datelabel.setBounds(34, 35, 57, 15);
		frame.getContentPane().add(datelabel);

		datelabel2 = new JLabel("1111_11_11");
		datelabel2.setBounds(93, 35, 88, 15);
		frame.getContentPane().add(datelabel2);

		tftitle = new JTextField();
		tftitle.setBounds(93, 7, 116, 21);
		frame.getContentPane().add(tftitle);
		tftitle.setColumns(10);

		btndel = new JButton("\uC0AD\uC81C");
		btndel.setBounds(140, 289, 70, 23);
		frame.getContentPane().add(btndel);

		btnclose = new JButton("\uB2EB\uAE30");
		btnclose.setBounds(238, 289, 70, 23);
		frame.getContentPane().add(btnclose);

	}

	public static CalGUI getInstance() {
		frmain = new CalGUI();
		// frmain.addCenter();
		return frmain;
	}

	public CalGUI() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
			System.out.println("asd");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		setSize(new Dimension(730, 250));
		setLayout(borderLayout1);
		dateModel = new SpinnerDateModel(new Date(), null, null,
				java.util.Calendar.YEAR);
		spinner = new JSpinner(dateModel);
		for (int i = 1; i < 13; i++)
			jComboBox1.addItem(i + "월");
		initTable();
		jComboBox1.addActionListener(this);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int year = 0;
				int mon = 0;
				Date d = (Date) spinner.getValue();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy");
				year = Integer.parseInt(myformat.format(d));
				mon = jComboBox1.getSelectedIndex() + 1;
				removeRowAll();
				initDay(year, mon, 1);
			}
		});

		// jLabel1.setBorder(BorderFactory.createEtchedBorder());
		jLabel1.setBorder(BorderFactory.createEtchedBorder());
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel1.setLayout(gridLayout1);
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		jPanel1.setBorder(BorderFactory.createEtchedBorder());
		jPanel1.add(spinner);
		jPanel1.add(jLabel2, null);
		jPanel1.add(jComboBox1, null);
		add(jPanel1, BorderLayout.NORTH);
		add(jScrollPane1, BorderLayout.CENTER);
		add(jLabel1, BorderLayout.SOUTH);

	}

	void initTable() {

		curDate = CalUtil.getTime();
		dm = new DefaultTableModel(0, 7);
		dm.setColumnIdentifiers(new Object[] { "일", "월", "화", "수", "목", "금",
				"토" });

		java.util.Calendar cal = java.util.Calendar.getInstance();
		Today_Y = cal.get(java.util.Calendar.YEAR);
		Today_M = cal.get(java.util.Calendar.MONTH) + 1;
		Today_D = cal.get(java.util.Calendar.DAY_OF_MONTH);
		jComboBox1.setSelectedItem(Today_M + "월");
		jLabel1.setText("오늘:" + Today_Y + "-" + Today_M + "-" + Today_D);
		initDay(Today_Y, Today_M, Today_D);

		jTable1 = new JTable(dm);
		jTable1.setRowHeight(20);
		jTable1.setShowHorizontalLines(false);
		jTable1.setShowVerticalLines(false);
		jTable1.getTableHeader().setResizingAllowed(false);
		jTable1.getTableHeader().setReorderingAllowed(false);
		jTable1.getColumnModel().getColumn(0)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		jTable1.getColumnModel().getColumn(1)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		jTable1.getColumnModel().getColumn(2)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		jTable1.getColumnModel().getColumn(3)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		jTable1.getColumnModel().getColumn(4)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		jTable1.getColumnModel().getColumn(5)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		jTable1.getColumnModel().getColumn(6)
				.setCellRenderer(new CalCellRenderer(this, curDate));
		CalCellEditor subedit = new CalCellEditor(new JCheckBox());
		jTable1.getColumnModel().getColumn(0).setCellEditor(subedit);
		jTable1.getColumnModel().getColumn(1).setCellEditor(subedit);
		jTable1.getColumnModel().getColumn(2).setCellEditor(subedit);
		jTable1.getColumnModel().getColumn(3).setCellEditor(subedit);
		jTable1.getColumnModel().getColumn(4).setCellEditor(subedit);
		jTable1.getColumnModel().getColumn(5).setCellEditor(subedit);
		jTable1.setBorder(BorderFactory.createEtchedBorder());
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable1.getColumnModel().getColumn(6).setCellEditor(subedit);
		jTable1.setGridColor(Color.white);

		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int column = jTable1.columnAtPoint(e.getPoint());
					int row = jTable1.rowAtPoint(e.getPoint());
					String tablevalue = "";
					// if(column != 0) return;
					tablevalue = jTable1.getValueAt(row, column).toString();
					if (tablevalue == null || tablevalue.equals("")) {
						return;
					} else {
						frame = new JFrame();
						frame.setBounds(100, 100, 355, 430);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.getContentPane().setLayout(null);
						frame.setVisible(true);
						CalMemo();
					}
				}
			}
		});

		jScrollPane1 = new JScrollPane(jTable1);

	}

	void initDay(int year, int month, int day) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month - 1, 1);
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner,
				"yyyy");
		spinner.setEditor(dateEditor);
		int lastDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		int firstDay = cal.get(java.util.Calendar.DAY_OF_WEEK);
		Object temp[];
		int daycount = 1;
		for (int i = 0; i < 6; i++) {
			temp = new Object[7];
			for (int j = 0; j < 7; j++) {
				if (firstDay - 1 > 0 || daycount > lastDay) {
					temp[j] = "";
					firstDay--;
					continue;
				} else
					temp[j] = daycount + "";
				daycount++;
			}
			dm.addRow(temp);
		}
	}

	public void actionPerformed(ActionEvent evt) {
		Object ob = evt.getSource();
		int mon = 1;
		int year = 1;

		if (ob.equals(jComboBox1)) {
			mon = jComboBox1.getSelectedIndex() + 1;
			year = getSpinnerYear();
			removeRowAll();
			initDay(year, mon, 1);
		}
	}

	public void removeRowAll() {
		while (dm.getRowCount() != 0) {
			dm.removeRow(0);
		}
	}

	public int getSpinnerYear() {
		Date d = (Date) spinner.getValue();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(myformat.format(d));
	}

	public int getMonth() {

		return jComboBox1.getSelectedIndex() + 1;
	}

}
