package com.workshop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.MemberDAO;
import com.dao.ProjectDAO;
import com.dto.ProjectDTO;

public class WorkshopGUI {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField tfid;
	private JLabel lblNewLabel_2;
	private JPasswordField tfpasswd;
	private JButton btnlogin;
	private JButton btnjoin;
	private JLabel lblNewLabel_3;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextField tfname;
	private JTextField tfstu_no;
	private JTextField tfID;
	private JPasswordField pfpasswd;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkshopGUI window = new WorkshopGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorkshopGUI() {
		initialize();
	}

	public void joinGUI() {

		lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 240", Font.BOLD, 20));
		lblNewLabel.setBounds(128, 29, 83, 47);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(57, 115, 35, 15);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("\uD559\uBC88");
		lblNewLabel_2.setBounds(57, 154, 35, 15);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_3.setBounds(57, 192, 48, 15);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_4.setBounds(57, 228, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("\uC0AC\uC9C4");
		lblNewLabel_5.setBounds(57, 268, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);

		tfname = new JTextField();
		tfname.setBounds(128, 112, 116, 21);
		frame.getContentPane().add(tfname);
		tfname.setColumns(10);

		tfstu_no = new JTextField();
		tfstu_no.setBounds(128, 151, 116, 21);
		frame.getContentPane().add(tfstu_no);
		tfstu_no.setColumns(10);

		tfID = new JTextField();
		tfID.setBounds(128, 189, 116, 21);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);

		pfpasswd = new JPasswordField();
		pfpasswd.setBounds(128, 225, 116, 21);
		frame.getContentPane().add(pfpasswd);

		btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // È¸¿ø°¡ÀÔ µî·Ï

				String id = tfID.getText();
				String passwd = pfpasswd.getText();
				String std_no = tfstu_no.getText();
				// Image img = ;
				String name = tfname.getText();
				MemberDAO dao = new MemberDAO();
				dao.CreateMember( id, passwd, std_no, name);

			}
		});
		btnNewButton.setBounds(66, 327, 97, 23);
		frame.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // È¸¿ø°¡ÀÔÃ¢ ²ô±â(Ãë¼Ò¹öÆ°)
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(187, 327, 97, 23);
		frame.getContentPane().add(btnNewButton_1);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel(
				"\uB124\uAC00 \uD574\uB77C \uC774 \uCF54\uB529");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±Ã¼­", Font.BOLD, 30));
		lblNewLabel.setBounds(197, 0, 360, 84);
		frame.getContentPane().add(lblNewLabel);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 93, 466, 356);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel_3 = new JLabel(
				"\uC9C4\uD589 \uC911\uC778 \uD504\uB85C\uC81D\uD2B8");
		lblNewLabel_3.setFont(new Font("±Ã¼­", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(116, 20, 226, 45);
		panel.add(lblNewLabel_3);

		scrollPane = new JScrollPane();
		scrollPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		scrollPane.setBounds(40, 86, 379, 243);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		ProjectDAO dao = new ProjectDAO();
		ArrayList<ProjectDTO> dto = dao.select();
		String[] header = { "ÇÁ·ÎÁ§Æ® ¸í" };
		int n = dto.size();
		Object[][] data = new Object[n][header.length];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = dto.get(i).getPro_title();
		}

		model.setDataVector(data, header);

		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(490, 93, 260, 139);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("±Ã¼­", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(27, 28, 57, 15);
		panel_1.add(lblNewLabel_1);

		tfid = new JTextField();
		tfid.setBounds(93, 25, 116, 21);
		panel_1.add(tfid);
		tfid.setColumns(10);

		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("±Ã¼­", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(27, 59, 57, 15);
		panel_1.add(lblNewLabel_2);

		tfpasswd = new JPasswordField();
		tfpasswd.setBounds(93, 56, 116, 21);
		panel_1.add(tfpasswd);

		btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ·Î±×ÀÎ ¹öÆ°

				if (tfid.equals("") && tfpasswd.getPassword().equals("")) {
					btnlogin.setText("·Î±×ÀÎ");
				} else {
					btnlogin.setText("·Î±×¾Æ¿ô");
				}

			}
		});
		btnlogin.setFont(new Font("±Ã¼­", Font.PLAIN, 12));
		btnlogin.setBounds(23, 106, 97, 23);
		panel_1.add(btnlogin);

		btnjoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // È¸¿ø°¡ÀÔ

				frame = new JFrame();
				frame.setBounds(100, 100, 355, 430);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				joinGUI();

			}
		});
		btnjoin.setFont(new Font("±Ã¼­", Font.PLAIN, 12));
		btnjoin.setBounds(151, 106, 97, 23);
		panel_1.add(btnjoin);

		btnNewButton_2 = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC0DD\uC131");
		btnNewButton_2.setFont(new Font("±Ã¼­", Font.PLAIN, 12));
		btnNewButton_2.setBounds(490, 342, 134, 23);
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC0AD\uC81C");
		btnNewButton_3.setFont(new Font("±Ã¼­", Font.PLAIN, 12));
		btnNewButton_3.setBounds(490, 389, 134, 23);
		frame.getContentPane().add(btnNewButton_3);
	}

}
