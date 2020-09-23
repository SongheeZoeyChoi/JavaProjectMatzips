package com.matzip.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.print.attribute.standard.SheetCollate;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;

import com.javalec.function.AddStoreBean;
import com.javalec.function.DbActionAddStore;
import com.javalec.function.ShareVar;
import com.matzip.beans.StoreBean;
import com.matzip.functions.StoreAction;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Font;

public class AddStore {

	private JFrame frame;
	private JLabel label;
	private JTextField tfStoreName;
	private JLabel label_1;
	private JTextField tfStoreAddress;
	private JLabel foodCategery;
	private JLabel storeOTime;
	private JLabel label_4;
	private JButton btnNewButton;
	private JLabel label_6;
	private JTextField tfStorePhone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox OTime;
	private JCheckBox CheckBoxMon;
	private JCheckBox checkBoxTue;
	private JCheckBox checkBoxWed;
	private JCheckBox checkBoxThu;
	private JCheckBox checkBoxFri;
	private JCheckBox checkBoxSat;
	private JCheckBox checkBoxSun;
	private JComboBox Otime2;
	private JCheckBox CheckBoxHansik;
	private JCheckBox checkBoxJungsik;
	private JCheckBox checkBoxYangsik;
	private JCheckBox checkBoxIlssik;
	private JCheckBox CheckBoxGuiter;
	private JComboBox Otime1;
	private JComboBox Otime3;
	private JLabel lblNewLabel;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel storeImage;

	String OPTime;
	String OPTime1;
	String OPTime2;
	String OPTime3;

	// private String foodCatetegery;
	// private String StoreOTime;
	private JButton btnFilePath;
	private JCheckBox checkBox;
	private JButton button;
	private JButton btnIdentify;
	private JButton btnPhonChek;
	private boolean StorePhoneCheckOk;
	private JCheckBox hoildayCheack;
	private JCheckBox openyearRound;
	private JLabel lbstoreAddress;
	private JPanel panel_1;
	private JLabel lblNewLabel_1_1;
	private JPanel panel;
	String filePath;
	private JCheckBox checkBoxHoliday;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStore window = new AddStore();
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
	public AddStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setTitle("매장추가");
		frame.setBounds(100, 100, 491, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLabel());
		frame.getContentPane().add(getTfStoreName());
		frame.getContentPane().add(getLabel_1());
		frame.getContentPane().add(getTfStoreAddress());
		frame.getContentPane().add(getFoodCategery());
		frame.getContentPane().add(getStoreOTime());
		frame.getContentPane().add(getLabel_4());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLabel_6());
		frame.getContentPane().add(getTfStorePhone());
		frame.getContentPane().add(getOTime());
		frame.getContentPane().add(getCheckBoxMon());
		frame.getContentPane().add(getCheckBoxTue());
		frame.getContentPane().add(getCheckBoxWed());
		frame.getContentPane().add(getCheckBoxThu());
		frame.getContentPane().add(getCheckBoxFri());
		frame.getContentPane().add(getCheckBoxSat());
		frame.getContentPane().add(getCheckBoxSun());
		frame.getContentPane().add(getOtime2());
		frame.getContentPane().add(getCheckBoxHansik());
		frame.getContentPane().add(getCheckBoxJungsik());
		frame.getContentPane().add(getCheckBoxYangsik());
		frame.getContentPane().add(getCheckBoxIlssik());
		frame.getContentPane().add(getCheckBoxGuiter());
		frame.getContentPane().add(getComboBox_1_1());
		frame.getContentPane().add(getOtime3());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLabel_8());
		frame.getContentPane().add(getLabel_9());
		frame.getContentPane().add(getLabel_10());
		frame.getContentPane().add(getStoreImage());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getCheckBox());
		frame.getContentPane().add(getButton());
		frame.getContentPane().add(getBtnPhonChek());
		frame.getContentPane().add(getHoildayCheack());
		frame.getContentPane().add(getOpenyearRound());
		frame.getContentPane().add(getLbstoreAddress());
		frame.getContentPane().add(getPanel_1());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getCheckBoxHoliday());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("매장명*");
			label.setBounds(158, 93, 51, 16);
		}
		return label;
	}

	private JTextField getTfStoreName() {
		if (tfStoreName == null) {
			tfStoreName = new JTextField();
			tfStoreName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 10) {
						tfStoreAddress.requestFocus();
					}
				}
			});
			tfStoreName.setBounds(213, 88, 254, 26);
			tfStoreName.setColumns(10);
		}
		return tfStoreName;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("주소");
			label_1.setBounds(158, 126, 51, 16);
		}
		return label_1;
	}

	private JTextField getTfStoreAddress() {
		if (tfStoreAddress == null) {
			tfStoreAddress = new JTextField();
			tfStoreAddress.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 10) {
						tfStorePhone.requestFocus();
					}
				}
			});
			tfStoreAddress.setColumns(10);
			tfStoreAddress.setBounds(213, 121, 254, 26);
		}
		return tfStoreAddress;
	}

	private JLabel getFoodCategery() {
		if (foodCategery == null) {
			foodCategery = new JLabel("음식종류*");
			foodCategery.setBounds(22, 254, 51, 16);
		}
		return foodCategery;
	}

	private JLabel getStoreOTime() {
		if (storeOTime == null) {
			storeOTime = new JLabel("영업시간");
			storeOTime.setBounds(22, 329, 51, 16);
		}
		return storeOTime;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("휴일");
			label_4.setBounds(22, 410, 51, 16);
		}
		return label_4;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("매장추가");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(CheckBlank()){
						//checkPhon();
						if(!lcheckPhone()) {
							if(StorePhoneCheckOk) {
								tfStorePhone.requestFocus();
								//JOptionPane.showMessageDialog(null, "전화번호를 숫자로만 입력해주세요.");
								storeOTime();
								foodCategery();
								holiday();
								InsertAction();
								StoreSearch.main(null);
								frame.dispose();
								
							}
							
						}
						
						
					}
					
					
					
				}
			});
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setBounds(350, 473, 117, 41);
		}
		return btnNewButton;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("전화번호*");
			label_6.setBounds(158, 159, 51, 16);
		}
		return label_6;
	}

	private JTextField getTfStorePhone() {
		if (tfStorePhone == null) {
			tfStorePhone = new JTextField();
			tfStorePhone.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
				}
			});
			
			
			tfStorePhone.setColumns(10);
			tfStorePhone.setBounds(213, 154, 254, 26);
		}
		return tfStorePhone;
	}

	private JComboBox getOTime() {
		if (OTime == null) {
			OTime = new JComboBox();
			OTime.setEnabled(false);
			OTime.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08",
					"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
			OTime.setBounds(77, 325, 99, 27);
		}
		return OTime;
	}

	private JCheckBox getCheckBoxMon() {
		if (CheckBoxMon == null) {
			CheckBoxMon = new JCheckBox("월");
			CheckBoxMon.setEnabled(false);
			CheckBoxMon.setBounds(7, 438, 51, 23);
		}
		return CheckBoxMon;
	}

	private JCheckBox getCheckBoxTue() {
		if (checkBoxTue == null) {
			checkBoxTue = new JCheckBox("화");
			checkBoxTue.setEnabled(false);
			checkBoxTue.setBounds(65, 438, 51, 23);
		}
		return checkBoxTue;
	}

	private JCheckBox getCheckBoxWed() {
		if (checkBoxWed == null) {
			checkBoxWed = new JCheckBox("수");
			checkBoxWed.setEnabled(false);
			checkBoxWed.setBounds(123, 438, 51, 23);
		}
		return checkBoxWed;
	}

	private JCheckBox getCheckBoxThu() {
		if (checkBoxThu == null) {
			checkBoxThu = new JCheckBox("목");
			checkBoxThu.setEnabled(false);
			checkBoxThu.setBounds(181, 438, 51, 23);
		}
		return checkBoxThu;
	}

	private JCheckBox getCheckBoxFri() {
		if (checkBoxFri == null) {
			checkBoxFri = new JCheckBox("금");
			checkBoxFri.setEnabled(false);
			checkBoxFri.setBounds(239, 438, 51, 23);
		}
		return checkBoxFri;
	}

	private JCheckBox getCheckBoxSat() {
		if (checkBoxSat == null) {
			checkBoxSat = new JCheckBox("토");
			checkBoxSat.setEnabled(false);
			checkBoxSat.setBounds(297, 438, 51, 23);
		}
		return checkBoxSat;
	}

	private JCheckBox getCheckBoxSun() {
		if (checkBoxSun == null) {
			checkBoxSun = new JCheckBox("일");
			checkBoxSun.setEnabled(false);
			checkBoxSun.setBounds(355, 438, 51, 23);
		}
		return checkBoxSun;
	}
	

	private JComboBox getOtime2() {
		if (Otime2 == null) {
			Otime2 = new JComboBox();
			Otime2.setEnabled(false);
			Otime2.setModel(new DefaultComboBoxModel(
					new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
							"14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
			Otime2.setBounds(77, 357, 99, 27);
		}
		return Otime2;
	}

	private JCheckBox getCheckBoxHansik() {
		if (CheckBoxHansik == null) {
			CheckBoxHansik = new JCheckBox("한식");
			CheckBoxHansik.setBounds(22, 279, 61, 23);
		}
		return CheckBoxHansik;
	}

	private JCheckBox getCheckBoxJungsik() {
		if (checkBoxJungsik == null) {
			checkBoxJungsik = new JCheckBox("중식");
			checkBoxJungsik.setBounds(87, 279, 61, 23);
		}
		return checkBoxJungsik;
	}

	private JCheckBox getCheckBoxYangsik() {
		if (checkBoxYangsik == null) {
			checkBoxYangsik = new JCheckBox("양식");
			checkBoxYangsik.setBounds(144, 279, 61, 23);
		}
		return checkBoxYangsik;
	}

	private JCheckBox getCheckBoxIlssik() {
		if (checkBoxIlssik == null) {
			checkBoxIlssik = new JCheckBox("일식");
			checkBoxIlssik.setBounds(205, 279, 61, 23);
		}
		return checkBoxIlssik;
	}

	private JCheckBox getCheckBoxGuiter() {
		if (CheckBoxGuiter == null) {
			CheckBoxGuiter = new JCheckBox("기타");
			CheckBoxGuiter.setBounds(271, 279, 61, 23);
		}
		return CheckBoxGuiter;
	}

	private JComboBox getComboBox_1_1() {
		if (Otime1 == null) {
			Otime1 = new JComboBox();
			Otime1.setEnabled(false);
			Otime1.setModel(new DefaultComboBoxModel(new String[] { "00", "05", "10", "15", "20", "25", "30", 
					"35", "40", "45", "50", "55" }));
			Otime1.setBounds(213, 325, 99, 27);
		}
		return Otime1;
	}

	private JComboBox getOtime3() {
		if (Otime3 == null) {
			Otime3 = new JComboBox();
			Otime3.setEnabled(false);
			Otime3.setModel(new DefaultComboBoxModel(new String[] { "00", "05", "10", "15", "20", "25", "30", 
					"35", "40", "45", "50", "55" }));
			Otime3.setBounds(213, 357, 99, 27);
		}
		return Otime3;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("분");
			lblNewLabel.setBounds(311, 329, 61, 16);
		}
		return lblNewLabel;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("분");
			label_8.setBounds(311, 361, 61, 16);
		}
		return label_8;
	}

	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("시");
			label_9.setBounds(176, 329, 29, 16);
		}
		return label_9;
	}

	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("시");
			label_10.setBounds(176, 361, 29, 16);
		}
		return label_10;
	}

	private JLabel getStoreImage() {
		if (storeImage == null) {
			storeImage = new JLabel("매장 이미지");
			storeImage.setIcon(new ImageIcon("/Users/tj/Documents/Kenny/Temp/null.png"));
			storeImage.setHorizontalAlignment(SwingConstants.CENTER);
			storeImage.setBounds(22, 82, 124, 113);
		}
		return storeImage;
	}

	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("이미지 추가");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(39, 207, 91, 29);
		}
		return btnFilePath;
	}

	private JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("모르겠어요");
			checkBox.setSelected(true);
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkBox.isSelected()) {
						OTime.setEnabled(false);
						Otime1.setEnabled(false);
						Otime2.setEnabled(false);
						Otime3.setEnabled(false);
					} else {
						OTime.setEnabled(true);
						Otime1.setEnabled(true);
						Otime2.setEnabled(true);
						Otime3.setEnabled(true);
					}

				}
			});
			checkBox.setBounds(341, 325, 91, 23);
		}
		return checkBox;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("취소");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StoreSearch.main(null);
					frame.dispose();
				}
			});
			button.setForeground(Color.RED);
			button.setBounds(228, 473, 117, 41);
		}
		return button;
	}

	private JCheckBox getHoildayCheack() {
		if (hoildayCheack == null) {
			hoildayCheack = new JCheckBox("휴일 모름");
			hoildayCheack.setSelected(true);
			hoildayCheack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (hoildayCheack.isSelected()) {
						CheckBoxMon.setSelected(false);
						checkBoxTue.setSelected(false);
						checkBoxWed.setSelected(false);
						checkBoxThu.setSelected(false);
						checkBoxFri.setSelected(false);
						checkBoxSat.setSelected(false);
						checkBoxSun.setSelected(false);
						checkBoxHoliday.setSelected(false);
						openyearRound.setSelected(false);
						
						CheckBoxMon.setEnabled(false);
						checkBoxTue.setEnabled(false);
						checkBoxWed.setEnabled(false);
						checkBoxThu.setEnabled(false);
						checkBoxFri.setEnabled(false);
						checkBoxSat.setEnabled(false);
						checkBoxSun.setEnabled(false);
						checkBoxHoliday.setEnabled(false);
						openyearRound.setEnabled(false);
						
					} else {
						CheckBoxMon.setEnabled(true);
						checkBoxTue.setEnabled(true);
						checkBoxWed.setEnabled(true);
						checkBoxThu.setEnabled(true);
						checkBoxFri.setEnabled(true);
						checkBoxSat.setEnabled(true);
						checkBoxSun.setEnabled(true);
						checkBoxHoliday.setEnabled(true);
						openyearRound.setEnabled(true);
					}
				
				}
			});
			hoildayCheack.setBounds(77, 406, 80, 23);
		}
		return hoildayCheack;
	}

	// ************ 영업시간 콤보박스**********************
	private String storeOTime() {
		// OPTime = OTime.getSelectedItem().toString();
		// OPTime1 = Otime1.getSelectedItem().toString();
		// OPTime2= Otime2.getSelectedItem().toString();
		// OPTime3=Otime3.getSelectedItem().toString();
		if (checkBox.isSelected()) {
			return "모르겠어요";
		}
		return OTime.getSelectedItem().toString() + "시" + Otime1.getSelectedItem().toString() + "분~"
				+ Otime2.getSelectedItem().toString() + "시" + Otime3.getSelectedItem().toString() + "분";

	}

	// ************ 데이터 불러오기 ***********************
	private void InsertAction() {
		String name = tfStoreName.getText();
		String Address = tfStoreAddress.getText();
		String Phone = tfStorePhone.getText();
		String OTime = storeOTime();
		String foodCategery = foodCategery();
		String holiday = holiday();
		String editer = ShareVar.GET_NICKNAME;
		// Image File
				FileInputStream input = null;
				if(filePath != null) {
					File file = new File(filePath);
					try {
						input = new FileInputStream(file);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				

		DbActionAddStore dbAction = new DbActionAddStore(name, Phone, Address, OTime, foodCategery, holiday, editer, input);
		boolean aaa = dbAction.InsertAction();
		if (aaa == true) {
			JOptionPane.showMessageDialog(null, tfStoreName.getText() + "의 정보가 입력 되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "입력중 에러가 발생했습니다 ./n 오류가 발생했습니다.");
		}
	}

	// ****************** 음식종류***********************
	private String foodCategery() {
		ArrayList<String> list = new ArrayList<String>();
		if (CheckBoxHansik.isSelected()) {
			list.add("한식");

		}
		if (checkBoxJungsik.isSelected()) {

			list.add("중식");
		}
		if (checkBoxYangsik.isSelected()) {

			list.add("양식");
		}
		if (checkBoxIlssik.isSelected()) {

			list.add("일식");
		}
		if (CheckBoxGuiter.isSelected()) {

			list.add("기타");
		}

		String str = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				str += list.get(i);
			} else {
				str += list.get(i) + " ";
			}
		}
		return str;

	}

	// ********************* 휴일메소드********************
	private String holiday() {
		ArrayList<String> list = new ArrayList<String>();
		if (CheckBoxMon.isSelected()) {
			list.add("월요일");
		}
		if (checkBoxTue.isSelected()) {
			list.add("화요일");
		}
		if (checkBoxWed.isSelected()) {
			list.add("수요일");
		}
		if (checkBoxThu.isSelected()) {
			list.add("목요일");
		}
		if (checkBoxFri.isSelected()) {
			list.add("금요일");
		}
		if (checkBoxSat.isSelected()) {
			list.add("토요일");
		}
		if (checkBoxSun.isSelected()) {
			list.add("일요일");
		}
		if (checkBoxHoliday.isSelected()) {
			list.add("공휴일");
		}
		if(openyearRound.isSelected()) {
			list.add("연중무휴");
		}
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				str += list.get(i);
			} else {
				str += list.get(i) + " ";
			}
		}
		if (hoildayCheack.isSelected()) {
			return "휴일모름";
		}
		return str;

	}

	// *******************이미지 파일**************
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg", "png", "bmp");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		filePath = chooser.getSelectedFile().getPath();
		Image PathImage = new ImageIcon(filePath).getImage().getScaledInstance(124, 113, Image.SCALE_SMOOTH);
		//tfstoreImage.setText(filePath);
		storeImage.setIcon(new ImageIcon(PathImage));
		storeImage.setHorizontalAlignment(SwingConstants.CENTER);
		storeImage.setText("");
	}

	// ******************** 필수등록은 작성하게 만드는 메소드****************
	private boolean CheckBlank() {
		if (tfStoreName.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "매장명을 입력하세요.");
			tfStoreName.requestFocus();
		} else if (tfStorePhone.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요.");
			tfStorePhone.requestFocus();
		} else if (foodCategery().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "음식종류를 입력하세요.");
		}
		else if(!StorePhoneCheckOk){
			btnPhonChek.requestFocus();
			JOptionPane.showMessageDialog(null, "중복체크를 확인주세요.");
		}else {
			return true;
			
		}
		return false;
	}

	private JButton getBtnPhonChek() {
		if (btnPhonChek == null) {
			btnPhonChek = new JButton("중복체크");
			btnPhonChek.setForeground(new Color(0, 0, 0));
			btnPhonChek.setBackground(Color.WHITE);
			btnPhonChek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tfStorePhone.getText().toString().trim().length()==0) {
						JOptionPane.showMessageDialog(null, "전화번호를 숫자로만 입력해주세요.");
					}else {
						checkPhone();
					}
					
				}
			});
			btnPhonChek.setBounds(376, 184, 91, 29);
		}
		return btnPhonChek;
	}

	// ************ 중복 체크 메소드*****************
	private void checkPhone() {
		StoreAction storeAction = new StoreAction();

		String newstorename = tfStorePhone.getText().trim();

		StorePhoneCheckOk = storeAction.checkPhone(newstorename);
		
	
		 if (!hasOnlyDigit(tfStorePhone.getText().trim())) {
			JOptionPane.showMessageDialog(null, "전화번호를 숫자로만 입력해주세요.");
			tfStorePhone.requestFocus();

		} else if (StorePhoneCheckOk) {
			JOptionPane.showMessageDialog(null, "사용가능한 전화번호입니다.");
		} else {
			JOptionPane.showMessageDialog(null, "이미 존재하는 전화번호입니다.");
		}
	}

	private boolean lcheckPhone() {
		StoreAction storeAction = new StoreAction();

		String newstorename = tfStorePhone.getText().trim();

		StorePhoneCheckOk = storeAction.checkPhone(newstorename);
		if(!StorePhoneCheckOk) {
			btnPhonChek.requestFocus();
			JOptionPane.showMessageDialog(null, "중복체크를 확인주세요.");
			return false;
		}else if (!hasOnlyDigit(tfStorePhone.getText().trim())) {
			//JOptionPane.showMessageDialog(null, "전화번호를 숫자로만 입력해주세요.");
			//tfStorePhone.requestFocus();
			return true;
		} else if (StorePhoneCheckOk) {
			//JOptionPane.showMessageDialog(null, "사용가능한 전화번호입니다.");
			return false;
		} else {
			//JOptionPane.showMessageDialog(null, "이미 존재하는 전화번호입니다.");
			return true;
		}
		//return false;
	}
	

	// ********** 비밀번호 숫자로만 사용하기 위한 메소드***************
	private boolean hasOnlyDigit(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) < '0' || string.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	private JCheckBox getOpenyearRound() {
		if (openyearRound == null) {
			openyearRound = new JCheckBox("연중무휴");
			openyearRound.setEnabled(false);
			openyearRound.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (openyearRound.isSelected()) {
						CheckBoxMon.setSelected(false);
						checkBoxTue.setSelected(false);
						checkBoxWed.setSelected(false);
						checkBoxThu.setSelected(false);
						checkBoxFri.setSelected(false);
						checkBoxSat.setSelected(false);
						checkBoxSun.setSelected(false);
						hoildayCheack.setSelected(false);
						CheckBoxMon.setEnabled(false);
						checkBoxTue.setEnabled(false);
						checkBoxWed.setEnabled(false);
						checkBoxThu.setEnabled(false);
						checkBoxFri.setEnabled(false);
						checkBoxSat.setEnabled(false);
						checkBoxSun.setEnabled(false);
						hoildayCheack.setEnabled(false);
					} else {
						CheckBoxMon.setEnabled(true);
						checkBoxTue.setEnabled(true);
						checkBoxWed.setEnabled(true);
						checkBoxThu.setEnabled(true);
						checkBoxFri.setEnabled(true);
						checkBoxSat.setEnabled(true);
						checkBoxSun.setEnabled(true);
						hoildayCheack.setEnabled(true);
					}
				}
			});
			openyearRound.setBounds(157, 406, 76, 23);
		}
		return openyearRound;
	}
	private JLabel getLbstoreAddress() {
		if (lbstoreAddress == null) {
			lbstoreAddress = new JLabel("전화번호 숫자로만 입력하세요");
			lbstoreAddress.setForeground(Color.RED);
			lbstoreAddress.setBounds(213, 189, 157, 16);
		}
		return lbstoreAddress;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(255, 127, 80));
			panel_1.setBounds(0, 0, 501, 60);
			panel_1.add(getLblNewLabel_1_1());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("매장추가");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Hiragino Kaku Gothic ProN", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(0, 0, 501, 60);
		}
		return lblNewLabel_1_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(22, 82, 124, 113);
		}
		return panel;
	}
	private JCheckBox getCheckBoxHoliday() {
		if (checkBoxHoliday == null) {
			checkBoxHoliday = new JCheckBox("공휴일");
			checkBoxHoliday.setEnabled(false);
			checkBoxHoliday.setBounds(413, 438, 68, 23);
		}
		return checkBoxHoliday;
	}
}
