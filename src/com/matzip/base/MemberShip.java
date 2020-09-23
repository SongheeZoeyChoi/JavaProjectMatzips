package com.matzip.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.matzip.functions.MemberShipAction;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JPanel;

public class MemberShip {

	private JFrame frame;
	private JLabel label;
	private JTextField tfNickname;
	private JLabel label_2;
	private JTextField tfEmailId;
	private JLabel label_3;
	private JPasswordField pfPassword;
	private JComboBox cbEmailAddress;
	private JTextField tfEmail;
	private JCheckBox checkBox;
	private JLabel lblNewLabel_1;
	private JLabel label_4;
	private JPasswordField pfCheckPassword;
	private JButton btnJoin;
	private JLabel lbPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnEmailCheck;
	private JButton btnNicknameCheck;
	private JLabel lbPasswordOk;

	private boolean nicknameCheckOK, emailCheckOK, passwordCheckOK;
	private String password;
	private JButton button;
	private JPanel panel_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberShip window = new MemberShip();
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
	public MemberShip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 490, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLabel());
		frame.getContentPane().add(getTfNickname());
		frame.getContentPane().add(getLabel_2());
		frame.getContentPane().add(getTfEmailId());
		frame.getContentPane().add(getLabel_3());
		frame.getContentPane().add(getPfPassword());
		frame.getContentPane().add(getCbEmailAddress());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getCheckBox());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLabel_4());
		frame.getContentPane().add(getPfCheckPassword());
		frame.getContentPane().add(getBtnJoin());
		frame.getContentPane().add(getLbPassword());
		frame.getContentPane().add(getBtnEmailCheck());
		frame.getContentPane().add(getBtnNicknameCheck());
		frame.getContentPane().add(getLbPasswordOk());
		frame.getContentPane().add(getButton());
		frame.getContentPane().add(getPanel_1());
	}

	private void checkNickname() {
		MemberShipAction memberShipAction = new MemberShipAction();

		String newNickname = tfNickname.getText().trim();

		if (newNickname.length() == 0) {
			JOptionPane.showMessageDialog(null, "닉네임을 입력해주세요.");
		} else {
			nicknameCheckOK = memberShipAction.checkNickname(newNickname);

			if (nicknameCheckOK) {
				JOptionPane.showMessageDialog(null, "사용가능한 닉네임입니다.");
			} else {
				JOptionPane.showMessageDialog(null, "이미 존재하는 닉네임입니다.");
			}
		}
	}

	private void checkEmail() {
		MemberShipAction memberShipAction = new MemberShipAction();

		String newEmail = tfEmail.getText().trim();

		if (newEmail.length() == 0) {
			JOptionPane.showMessageDialog(null, "이메일 아이디를 입력해주세요.");
		} else {
			String newEmailAddress = newEmail.substring(newEmail.indexOf("@") + 1);
			if (newEmailAddress.length() == 0) {
				JOptionPane.showMessageDialog(null, "이메일 주소를 입력해주세요.");
			} else {
				emailCheckOK = memberShipAction.checkEmail(newEmail);

				if (emailCheckOK) {
					JOptionPane.showMessageDialog(null, "사용가능한 이메일입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "이미 존재하는 이메일입니다.");
				}
			}
		}
	}

	private void toggleSelfWriteEmail() {
		if (checkBox.isSelected()) {
			cbEmailAddress.setSelectedIndex(0);
			cbEmailAddress.setEnabled(false);
			tfEmailId.setEditable(false);
			tfEmail.setEditable(true);
		} else {
			cbEmailAddress.setEnabled(true);
			tfEmail.setEditable(false);
			tfEmailId.setEditable(true);
			cbEmailAddress.requestFocus();
		}
	}

	private boolean passwordConditionOk() {
		if (password.length() < 4 || password.length() > 12) {
			return false;
		} else if (password.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			return false;
		} else if (password.matches("^[a-zA-Z0-9]+$")) {
			return true;
		}
		return false;
	}

	private void checkPassword() {
		passwordCheckOK = false;
		String checkPassword = pfCheckPassword.getText().trim();
		if (password.length() == 0) {
			lbPasswordOk.setText("");
		} else if (passwordConditionOk()) {
			if (checkPassword.length() != 0) {
				if (password.equals(checkPassword)) {
					lbPasswordOk.setText("비밀번호가 일치합니다.");
					lbPasswordOk.setForeground(Color.BLUE);
					passwordCheckOK = true;
					btnJoin.setEnabled(true);
				} else {
					lbPasswordOk.setText("비밀번호가 일치하지 않습니다.");
					lbPasswordOk.setForeground(Color.RED);
					passwordCheckOK = false;
				}
			}
		} else {
			lbPasswordOk.setText("");
		}
	}

	private void registerAction() {
		if (!nicknameCheckOK) {
			btnNicknameCheck.requestFocus();
			JOptionPane.showMessageDialog(null, "닉네임 중복확인을 해주세요.");
		} else if (!emailCheckOK) {
			btnEmailCheck.requestFocus();
			JOptionPane.showMessageDialog(null, "이메일 중복확인을 해주세요.");
		} else if (!passwordCheckOK) {
			pfCheckPassword.requestFocus();
			JOptionPane.showMessageDialog(null, "비밀번호를 확인 해주세요.");
		} else {
			MemberShipAction memberShipAction = new MemberShipAction(tfNickname.getText().trim(),
					tfEmail.getText().trim(), password);
			boolean registerOK = memberShipAction.registerAction();
			if (registerOK) {
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다. ");
				Login.main(null);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "오류가 발생했습니다.\n다시 시도해주세요.");
			}
		}
	}

	private void setEmailField() {
		String email = "";

		if (tfEmailId.getText().trim().length() != 0) {
			email = tfEmailId.getText().trim() + "@";
		}
		if (cbEmailAddress.getSelectedIndex() != 0) {
			switch (cbEmailAddress.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				email += "naver.com";
				break;
			case 2:
				email += "daum.net";
				break;
			case 3:
				email += "gmail.com";
				break;
			default:
				break;
			}
		}

		tfEmail.setText(email);
	}

	///////////////////////////////
	///////////// 컴포넌트////////////
	///////////////////////////////
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("닉네임");
			label.setBounds(25, 77, 44, 16);
		}
		return label;
	}

	private JTextField getTfNickname() {
		if (tfNickname == null) {
			tfNickname = new JTextField();
			tfNickname.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					nicknameCheckOK = false;
				}
			});
			tfNickname.setColumns(10);
			tfNickname.setBounds(80, 72, 120, 26);
		}
		return tfNickname;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("이메일");
			label_2.setBounds(25, 111, 51, 16);
		}
		return label_2;
	}

	private JTextField getTfEmailId() {
		if (tfEmailId == null) {
			tfEmailId = new JTextField();
			tfEmailId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String emailId = tfEmailId.getText().trim();
					emailId = emailId.replaceAll("[^0-9a-zA-Z\\s]", "");
					tfEmailId.setText(emailId);
					if (emailId.length() != 0) {
						setEmailField();
					} else {
						tfEmail.setText("");
					}
				}
			});
			tfEmailId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (tfEmailId.getText().trim().length() != 0) {
						setEmailField();
					} else {
						tfEmail.setText("");
					}
				}
			});
			tfEmailId.setColumns(10);
			tfEmailId.setBounds(80, 106, 120, 26);
		}
		return tfEmailId;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("비밀번호");
			label_3.setBounds(25, 179, 51, 16);
		}
		return label_3;
	}

	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					password = pfPassword.getText().trim();
					checkPassword();
					if (passwordConditionOk()) {
						lbPassword.setText("사용가능한 비밀번호입니다.");
						lbPassword.setForeground(Color.BLUE);
					} else {
						lbPassword.setText("비밀번호 설정시에는 4~12자리 영문 또는 숫자를 사용해주세요!");
						lbPassword.setForeground(Color.RED);
					}
				}
			});
			pfPassword.setColumns(10);
			pfPassword.setBounds(80, 175, 273, 26);
		}
		return pfPassword;
	}

	private JComboBox getCbEmailAddress() {
		if (cbEmailAddress == null) {
			cbEmailAddress = new JComboBox();
			cbEmailAddress.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!tfEmailId.getText().equals("")) {
						setEmailField();
						// selectEmailAddress(tfEmailId.getText().trim() + "@");
					}
				}
			});
			cbEmailAddress.setModel(new DefaultComboBoxModel(new String[] { "선택하세요", "네이버", "다음", "구글" }));
			cbEmailAddress.setBounds(218, 106, 133, 27);
		}
		return cbEmailAddress;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String email = tfEmail.getText().trim();
					email = email.replaceAll("[^@.0-9a-zA-Z\\s]", "");
					tfEmail.setText(email);
				}
			});
			tfEmail.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					if (tfEmail.getText().trim().contains("@")) {
						tfEmailId.setText(tfEmail.getText().trim().substring(0, tfEmail.getText().trim().indexOf("@")));
					} else {
						tfEmailId.setText("");
					}
					emailCheckOK = false;
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					if (tfEmail.getText().trim().contains("@")) {
						tfEmailId.setText(tfEmail.getText().trim().substring(0, tfEmail.getText().trim().indexOf("@")));
					} else {
						tfEmailId.setText("");
					}
					emailCheckOK = false;
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
				}
			});
			tfEmail.setEditable(false);
			tfEmail.setBounds(80, 139, 261, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}

	private JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("직접입력");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toggleSelfWriteEmail();
				}
			});
			checkBox.setBounds(341, 140, 86, 23);
		}
		return checkBox;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("@");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(198, 111, 24, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("비밀번호확인");
			label_4.setBounds(25, 241, 73, 16);
		}
		return label_4;
	}

	private JPasswordField getPfCheckPassword() {
		if (pfCheckPassword == null) {
			pfCheckPassword = new JPasswordField();
			pfCheckPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (pfCheckPassword.getText().trim().length() != 0) {
						checkPassword();
					} else {
						lbPasswordOk.setText("");
					}
				}
			});
			pfCheckPassword.setColumns(10);
			pfCheckPassword.setBounds(100, 237, 273, 26);
		}
		return pfCheckPassword;
	}

	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입하기");
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registerAction();
				}
			});
			btnJoin.setForeground(Color.BLUE);
			btnJoin.setBounds(363, 275, 117, 41);
		}
		return btnJoin;
	}

	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("비밀번호 설정시에는 4~12자리 영문 또는 숫자를 사용해주세요!");
			lbPassword.setForeground(Color.RED);
			lbPassword.setBounds(25, 207, 370, 29);
		}
		return lbPassword;
	}

	private JButton getBtnEmailCheck() {
		if (btnEmailCheck == null) {
			btnEmailCheck = new JButton("중복체크");
			btnEmailCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfEmail.getText().contains("@") && tfEmail.getText().contains(".")) {
						checkEmail();
					} else {
						JOptionPane.showMessageDialog(null, "올바르지 않은 이메일 형식입니다.");
					}
				}
			});
			btnEmailCheck.setForeground(Color.RED);
			btnEmailCheck.setBounds(363, 105, 117, 29);
		}
		return btnEmailCheck;
	}

	private JButton getBtnNicknameCheck() {
		if (btnNicknameCheck == null) {
			btnNicknameCheck = new JButton("중복체크");
			btnNicknameCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkNickname();
				}
			});
			btnNicknameCheck.setForeground(Color.RED);
			btnNicknameCheck.setBounds(218, 72, 117, 29);
		}
		return btnNicknameCheck;
	}

	private JLabel getLbPasswordOk() {
		if (lbPasswordOk == null) {
			lbPasswordOk = new JLabel("");
			lbPasswordOk.setBounds(25, 269, 197, 16);
		}
		return lbPasswordOk;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("취소");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login.main(null);
					frame.dispose();
				}
			});
			button.setBounds(246, 275, 117, 41);
		}
		return button;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(255, 127, 80));
			panel_1.setBounds(0, 0, 490, 60);
			panel_1.add(getLblNewLabel_1_1());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("회원가입");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Hiragino Kaku Gothic ProN", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(0, 0, 490, 60);
		}
		return lblNewLabel_1_1;
	}
}
