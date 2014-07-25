package com.workshop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.DocumentDAO;
import com.dto.DocumentDTO;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class ProjectGUI {

	private JFrame frame;
	private javax.swing.JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfwriter;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextArea tfcontent;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectGUI window = new ProjectGUI();
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
	public ProjectGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new javax.swing.JTabbedPane(javax.swing.JTabbedPane.TOP);
		tabbedPane.setBounds(37, 72, 739, 543);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("프로젝트 정보", null, panel, null);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("프로젝트 일정", null, panel_1, null);
		panel_1.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(8, 20, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("캘린더", null, panel_2, null);
		panel_2.setLayout(null);

		
		panel_3 = new JPanel();
		tabbedPane.addTab("게시판", null, panel_3, null);
		panel_3.setLayout(null);
		
		btnNewButton_1 = new JButton("\uC791\uC131");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //작성버튼
				int doc_no = 0;
				String content = tfcontent.getText();
				String writer = tfwriter.getText();
				DocumentDAO dao = new DocumentDAO();
				//dao.insert(content, writer);
				
			}
		});
		btnNewButton_1.setBounds(592, 332, 60, 23);
		panel_3.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 10, 582, 310);
		panel_3.add(scrollPane);
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		DefaultTableModel model = new DefaultTableModel();
		table_1.setModel(model);
		String[] header = { "번호", "내용", "작성자" };
		DocumentDAO dao = new DocumentDAO();
		ArrayList<DocumentDTO> dto = dao.select();
		int n = dto.size();
		Object[][] data = new Object[n][header.length];
		for(int i=0; i<data.length; i++){
			//data[i][0] = dto.get(i).
		}
		model.setDataVector(data, header);
		
		lblNewLabel_1 = new JLabel("\uB0B4\uC6A9");
		lblNewLabel_1.setBounds(70, 336, 38, 15);
		panel_3.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uC791\uC131\uC790");
		lblNewLabel_2.setBounds(436, 336, 45, 15);
		panel_3.add(lblNewLabel_2);
		
		tfwriter = new JTextField();
		tfwriter.setBounds(484, 333, 96, 21);
		panel_3.add(tfwriter);
		tfwriter.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC774\uB984"}));
		comboBox.setBounds(387, 451, 72, 27);
		panel_3.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(482, 454, 129, 21);
		panel_3.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(623, 453, 77, 23);
		panel_3.add(btnNewButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(107, 330, 300, 100);
		panel_3.add(scrollPane_1);
		
		tfcontent = new JTextArea();
		scrollPane_1.setViewportView(tfcontent);
		tfcontent.setLineWrap(true);
		
		lblNewLabel = new JLabel("\uC81C\uBAA9"); //프로젝트 이름 set
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(254, 10, 315, 36);
		frame.getContentPane().add(lblNewLabel);
	}
}
