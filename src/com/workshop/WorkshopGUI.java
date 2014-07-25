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
import javax.swing.JOptionPane;
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
	private JButton btncreate;
	private JButton btndelete;
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
	
	public void JoinGUI(){
		
		lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 20));
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
		
		tfname = new JTextField();
		tfname.setBounds(128, 112, 116, 21);
		frame.getContentPane().add(tfname);
		tfname.setColumns(10);
		
		tfstu_no = new JTextField();
		tfstu_no.setBounds(128, 151, 116, 21);
		frame.getContentPane().add(tfstu_no);
		tfstu_no.setColumns(10);
		
		tfID= new JTextField();
		tfID.setBounds(128, 189, 116, 21);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);
		
		pfpasswd = new JPasswordField();
		pfpasswd.setBounds(128, 225, 116, 21);
		frame.getContentPane().add(pfpasswd);
		
		btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //회원가입 등록
				
				int m_no = 1;
				String id = tfID.getText();
				String passwd = pfpasswd.getText();
				String std_no = tfstu_no.getText();
				String name = tfname.getText();
				MemberDAO dao = new MemberDAO();
				dao.CreateMember(m_no, name, id, passwd, std_no);
				
				if(id.equals("")){
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요", "아이디 입력",  JOptionPane.WARNING_MESSAGE);
				}
				if(btnNewButton.isSelected()){
					JOptionPane.showConfirmDialog(null, "회원가입 성공", "회원가입", 0, JOptionPane.OK_OPTION);
				}
				
			}
		});
		btnNewButton.setBounds(66, 327, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //회원가입창 끄기(취소버튼)
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
		lblNewLabel.setFont(new Font("궁서", Font.BOLD, 30));
		lblNewLabel.setBounds(197, 0, 360, 84);
		frame.getContentPane().add(lblNewLabel);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 93, 466, 356);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel_3 = new JLabel(
				"\uC9C4\uD589 \uC911\uC778 \uD504\uB85C\uC81D\uD2B8");
		lblNewLabel_3.setFont(new Font("궁서", Font.BOLD, 15));
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
		String[] header = { "프로젝트 명" };
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
		lblNewLabel_1.setFont(new Font("궁서", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(27, 28, 57, 15);
		panel_1.add(lblNewLabel_1);

		tfid = new JTextField();
		tfid.setBounds(93, 25, 116, 21);
		panel_1.add(tfid);
		tfid.setColumns(10);

		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("궁서", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(27, 59, 57, 15);
		panel_1.add(lblNewLabel_2);

		tfpasswd = new JPasswordField();
		tfpasswd.setBounds(93, 56, 116, 21);
		panel_1.add(tfpasswd);

		btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 로그인 버튼

				MemberDAO dao = new MemberDAO();
				String id = tfid.getText();
				String password = tfpasswd.getText();
				if(id.equals("")||password.equals("")){
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.", "로그인", JOptionPane.WARNING_MESSAGE);
				}
				else{
					boolean existLogin = dao.search(id, password);
					if(existLogin==true){
						JOptionPane.showMessageDialog(null, "로그인 성공");
						//frame.getContentPane().removeAll();
						btnlogin.setText("로그아웃");
					}
					else{
						JOptionPane.showMessageDialog(null, "로그인 실패");

					}
				}
				password = null;

			}
		});
		btnlogin.setFont(new Font("궁서", Font.PLAIN, 12));
		btnlogin.setBounds(23, 106, 97, 23);
		panel_1.add(btnlogin);

		btnjoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 회원가입
				
				frame = new JFrame();
				frame.setBounds(100, 100, 355, 430);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				JoinGUI();
			}
		});
		btnjoin.setFont(new Font("궁서", Font.PLAIN, 12));
		btnjoin.setBounds(151, 106, 97, 23);
		panel_1.add(btnjoin);
		
		btncreate = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC0DD\uC131");
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//프로젝트 생성 버튼
				
				frame = new JFrame();
				frame.setBounds(100, 100, 355, 430);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				
			}
		});
		btncreate.setFont(new Font("궁서", Font.PLAIN, 12));
		btncreate.setBounds(490, 342, 134, 23);
		frame.getContentPane().add(btncreate);
		
		btndelete = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC0AD\uC81C");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//프로젝트 삭제 버튼
				
				
			}
		});
		btndelete.setFont(new Font("궁서", Font.PLAIN, 12));
		btndelete.setBounds(490, 389, 134, 23);
		frame.getContentPane().add(btndelete);
	}

}
