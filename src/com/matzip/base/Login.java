package com.matzip.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.function.DbActionLogin;

import com.javalec.function.LoginBean;
import com.javalec.function.ShareVar;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Login {
	
	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfLoginEmail;
	private JLabel lblNewLabel_2;
	private JButton btnLogin;

	private JButton btnJoinMember;
	private JLabel lblNewLabel_1;
	private JPasswordField pfLoginPassword;

	
	//전역변수 
	int finalLoginIndex = 0;
	private JPanel panel;
	private JPanel panel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인");
		frame.setBounds(100, 100, 370, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //모니터중간배치 
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getPanel_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("E-mail");
			lblNewLabel.setBounds(46, 29, 47, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfLoginEmail() {
		if (tfLoginEmail == null) {
			tfLoginEmail = new JTextField();
			tfLoginEmail.setForeground(Color.BLACK);
			tfLoginEmail.setBounds(41, 47, 289, 38);
			tfLoginEmail.setColumns(10);
		}
		return tfLoginEmail;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Password");
			lblNewLabel_2.setBounds(47, 97, 71, 16);
		}
		return lblNewLabel_2;
	}
	private JPasswordField getPfLoginPassword() {
		if (pfLoginPassword == null) {
			pfLoginPassword = new JPasswordField();
			pfLoginPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					// 엔터 로그인 
					if(e.getKeyCode() == 10 ) {
						btnLogin.doClick();
					}
				}
			});
			pfLoginPassword.setBounds(41, 114, 289, 38);
		}
		return pfLoginPassword;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("LOG IN");
			btnLogin.setBounds(199, 173, 117, 40);
			btnLogin.setBackground(Color.PINK);
			btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(CheckId()==true) {
						if(CheckPassword(finalLoginIndex)){
							StoreSearch.main(null);			   // nickname으로 메인 화면 들어가기 
							frame.dispose();
						} 
					} else{
						JOptionPane.showMessageDialog(null, "Cant find Id");
					}
					
				}
			});
			btnLogin.setForeground(new Color(0, 0, 0));
		}
		return btnLogin;
	}
	private JButton getBtnJoinMember() {
		if (btnJoinMember == null) {
			btnJoinMember = new JButton("SIGN UP");
			btnJoinMember.setBounds(51, 173, 117, 40);
			btnJoinMember.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnJoinMember.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberShip.main(null);
					frame.dispose();
				}
			});
			btnJoinMember.setForeground(new Color(0, 0, 0));
		}
		return btnJoinMember;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("MATZIP's");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(0, 0, 370, 60);
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Hiragino Kaku Gothic ProN", Font.PLAIN, 20));
		}
		return lblNewLabel_1;
	}
	
	
	public boolean CheckId() {

		DbActionLogin dbActionLogin = new DbActionLogin(tfLoginEmail.getText()); // 값있는 DbActionLogin 생성자

		ArrayList<LoginBean> loginBeanList = dbActionLogin.GetCustoInfo(); //

		int loginlistCount = loginBeanList.size();
		// 입력한 이메일과 = DB 배열 이메일 일치 확인
		for (int loginIndex = 0; loginIndex < loginlistCount; loginIndex++) {
			if (tfLoginEmail.getText().equals(loginBeanList.get(loginIndex).getEmail())) {
				finalLoginIndex = loginIndex;
				return true;
			}
		}
		return false;
	}	
	
	private boolean CheckPassword(int finalLoginIndex) {

		DbActionLogin dbActionLogin = new DbActionLogin(tfLoginEmail.getText());

		ArrayList<LoginBean> loginBeanList = dbActionLogin.GetCustoInfo();

		if (PasswordToString(pfLoginPassword.getPassword()).equals(loginBeanList.get(finalLoginIndex).getPassword())) {
			// custoNo
			
			int getCustoNo = loginBeanList.get(finalLoginIndex).getCustoNo();
			
			// nickname
			String nickname = loginBeanList.get(finalLoginIndex).getNickname();
			
			JOptionPane.showMessageDialog(null, nickname + " Login Succeeded");

			ShareVar.GET_NICKNAME = nickname;
			ShareVar.CUSTO_CUSTONO = getCustoNo;
		
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Check Password");
			return false;
		}
	}
	

	private String PasswordToString(char[] password) {
		String pwd = new String(password);
		return pwd;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(245, 222, 179));
			panel.setBounds(0, 60, 370, 243);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTfLoginEmail());
			panel.add(getLblNewLabel_2());
			panel.add(getPfLoginPassword());
			panel.add(getBtnJoinMember());
			panel.add(getBtnLogin());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 127, 80));
			panel_1.setBounds(0, 0, 370, 60);
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel_1());
		}
		return panel_1;
	}
}//<------
