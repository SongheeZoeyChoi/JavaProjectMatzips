package com.matzip.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.function.DbActionReview;
//import com.javalec.function.DbAction;
import com.javalec.function.ShareVar;
import com.matzip.beans.StoreBean;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Review {

	private JFrame frame;
	private JLabel lblRvGrade;
	private JRadioButton rdGrade5;
	private JRadioButton rdGrade4;
	private JRadioButton rdGrade3;
	private JRadioButton rdGrade2;
	private JRadioButton rdGrade1;
	private JLabel lblRvPhoto;
	private JLabel lblRvImage;
	private JLabel lblRvMenu;
	private JTextField tfRvMenu;
	private JLabel lblRvPrice;
	private JRadioButton rdPriceLess1;
	private JRadioButton rdPriceB1A3;
	private JRadioButton rdPriceB3A5;
	private JRadioButton rdPriceB5A10;
	private JRadioButton rdPriceMore10;
	private JLabel lblRvContents;
	private JButton btnInsert;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnReviewFilePath;
	private JButton button;
	private JLabel lbStoreName;
	private JScrollPane scrollPane;
	private JTextArea taRvContents;
	private JPanel panel;
	
	//
	private String filePath =null;
	ImageIcon defaultReview = new ImageIcon("/Users/tj/Documents/csh8881/Matzip's/defaultReview.png");
	Image defaultReviewImg = defaultReview.getImage().getScaledInstance(180, 108, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review window = new Review();
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
	public Review() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lbStoreName.setText(StoreBean.getStoreName() + "의 리뷰를 작성해 보세요!");
				
			}
		});
		frame.setTitle("리뷰쓰기");
		frame.setBounds(100, 100, 484, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //모니터중간배치 
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblRvGrade());
		frame.getContentPane().add(getRdGrade5());
		frame.getContentPane().add(getRdGrade4());
		frame.getContentPane().add(getRdGrade3());
		frame.getContentPane().add(getRdGrade2());
		frame.getContentPane().add(getRdGrade1());
		frame.getContentPane().add(getLblRvPhoto());
		frame.getContentPane().add(getLblRvImage());
		frame.getContentPane().add(getLblRvMenu());
		frame.getContentPane().add(getTfRvMenu());
		frame.getContentPane().add(getLblRvPrice());
		frame.getContentPane().add(getRdPriceLess1());
		frame.getContentPane().add(getRdPriceB1A3());
		frame.getContentPane().add(getRdPriceB3A5());
		frame.getContentPane().add(getRdPriceB5A10());
		frame.getContentPane().add(getRdPriceMore10());
		frame.getContentPane().add(getLblRvContents());
		frame.getContentPane().add(getBtnInsert());
		frame.getContentPane().add(getButton_1());
		frame.getContentPane().add(getButton());
		frame.getContentPane().add(getLbStoreName());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getPanel());
	}

	private JLabel getLblRvGrade() {
		if (lblRvGrade == null) {
			lblRvGrade = new JLabel("평점*");
			lblRvGrade.setBounds(22, 228, 48, 16);
		}
		return lblRvGrade;
	}
	private JRadioButton getRdGrade5() {
		if (rdGrade5 == null) {
			rdGrade5 = new JRadioButton("5");
			rdGrade5.setSelected(true);
			buttonGroup.add(rdGrade5);
			rdGrade5.setBounds(108, 226, 40, 23);
		}
		return rdGrade5;
	}
	private JRadioButton getRdGrade4() {
		if (rdGrade4 == null) {
			rdGrade4 = new JRadioButton("4");
			buttonGroup.add(rdGrade4);
			rdGrade4.setBounds(160, 226, 40, 23);
		}
		return rdGrade4;
	}
	private JRadioButton getRdGrade3() {
		if (rdGrade3 == null) {
			rdGrade3 = new JRadioButton("3");
			buttonGroup.add(rdGrade3);
			rdGrade3.setBounds(212, 226, 40, 23);
		}
		return rdGrade3;
	}
	private JRadioButton getRdGrade2() {
		if (rdGrade2 == null) {
			rdGrade2 = new JRadioButton("2");
			buttonGroup.add(rdGrade2);
			rdGrade2.setBounds(264, 226, 40, 23);
		}
		return rdGrade2;
	}
	private JRadioButton getRdGrade1() {
		if (rdGrade1 == null) {
			rdGrade1 = new JRadioButton("1");
			buttonGroup.add(rdGrade1);
			rdGrade1.setBounds(316, 226, 40, 23);
		}
		return rdGrade1;
	}
	private JLabel getLblRvPhoto() {
		if (lblRvPhoto == null) {
			lblRvPhoto = new JLabel("사진");
			lblRvPhoto.setBounds(22, 147, 29, 16);
		}
		return lblRvPhoto;
	}
	private JLabel getLblRvImage() {
		if (lblRvImage == null) {
			lblRvImage = new JLabel("");
			lblRvImage.setIcon(new ImageIcon(defaultReviewImg));
			lblRvImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblRvImage.setBounds(109, 106, 180, 108);
		}
		return lblRvImage;
	}
	private JLabel getLblRvMenu() {
		if (lblRvMenu == null) {
			lblRvMenu = new JLabel("메뉴 이름");
			lblRvMenu.setBounds(22, 263, 57, 16);
		}
		return lblRvMenu;
	}
	private JTextField getTfRvMenu() {
		if (tfRvMenu == null) {
			tfRvMenu = new JTextField();
			tfRvMenu.setBounds(108, 261, 348, 29);
			tfRvMenu.setColumns(10);
		}
		return tfRvMenu;
	}
	private JLabel getLblRvPrice() {
		if (lblRvPrice == null) {
			lblRvPrice = new JLabel("인당 가격대*");
			lblRvPrice.setBounds(22, 302, 70, 16);
		}
		return lblRvPrice;
	}
	private JRadioButton getRdPriceLess1() {
		if (rdPriceLess1 == null) {
			rdPriceLess1 = new JRadioButton("1만 원 미만");
			rdPriceLess1.setSelected(true);
			buttonGroup_1.add(rdPriceLess1);
			rdPriceLess1.setBounds(108, 300, 92, 23);
		}
		return rdPriceLess1;
	}
	private JRadioButton getRdPriceB1A3() {
		if (rdPriceB1A3 == null) {
			rdPriceB1A3 = new JRadioButton("1~3만 원 미만");
			buttonGroup_1.add(rdPriceB1A3);
			rdPriceB1A3.setBounds(224, 300, 110, 23);
		}
		return rdPriceB1A3;
	}
	private JRadioButton getRdPriceB3A5() {
		if (rdPriceB3A5 == null) {
			rdPriceB3A5 = new JRadioButton("3~5만 원 미만");
			buttonGroup_1.add(rdPriceB3A5);
			rdPriceB3A5.setBounds(346, 300, 110, 23);
		}
		return rdPriceB3A5;
	}
	private JRadioButton getRdPriceB5A10() {
		if (rdPriceB5A10 == null) {
			rdPriceB5A10 = new JRadioButton("5~10만 원 미만");
			buttonGroup_1.add(rdPriceB5A10);
			rdPriceB5A10.setBounds(108, 322, 122, 23);
		}
		return rdPriceB5A10;
	}
	private JRadioButton getRdPriceMore10() {
		if (rdPriceMore10 == null) {
			rdPriceMore10 = new JRadioButton("10만 원 이상");
			buttonGroup_1.add(rdPriceMore10);
			rdPriceMore10.setBounds(224, 322, 110, 23);
		}
		return rdPriceMore10;
	}
	private JLabel getLblRvContents() {
		if (lblRvContents == null) {
			lblRvContents = new JLabel("내용*");
			lblRvContents.setBounds(22, 369, 48, 16);
		}
		return lblRvContents;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("등록");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkBlank()) {
					InsertReviewAction(); //---
					StoreInformation.main(null);
					frame.dispose();
					}
					
				}
			});
			btnInsert.setBounds(380, 513, 77, 39);
		}
		return btnInsert;
	}
	private JButton getButton_1() {
		if (btnReviewFilePath == null) {
			btnReviewFilePath = new JButton("올리기");
			btnReviewFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReviewFilePath();
					
				}
			});
			btnReviewFilePath.setBounds(10, 165, 77, 29);
		}
		return btnReviewFilePath;
	}
	
	
	//Method 
	
	//사진올리기 
	private void ReviewFilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		filePath = chooser.getSelectedFile().getPath();
		//tfReviewFilePath.setText(filePath);
		
		ImageIcon aaa = new ImageIcon(filePath);
		Image storeImage = new ImageIcon(filePath).getImage().getScaledInstance(180, 108, Image.SCALE_SMOOTH);
		lblRvImage.setIcon(new ImageIcon(storeImage));
		
		
		lblRvImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
	//리뷰 등록 
	private void InsertReviewAction() {
		
		String reviewGrade = SelectedReviewGradeToString(); // 리뷰평점
		String reviewMenu = tfRvMenu.getText();
		String reviewPrice = SelectedReviewPriceToStirng(); // 리뷰가격대
		String reviewContents = taRvContents.getText();
				
		// 닉네임 을 Share Var 에서 가져옴 
		String nickname = ShareVar.GET_NICKNAME.toString();
		// ---------------
		// 고객번호를 Share Var 에서 가져옴 
		int customer_custoNo = ShareVar.CUSTO_CUSTONO;
		
		//매장번호  Share Var 에서 가져옴 
		int store_storeNo = ShareVar.ROW;
	
		// --------------
		
		
		// Image File
		FileInputStream input = null;
		if(filePath != null) {
			File file = new File(filePath);
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		// 리뷰 값 입력 : 평점, 내용, 메뉴, 가격, 닉네임, 매장번호. 사진. 
		//DbActionReview dbWriteReviewAction = new DbActionReview(reviewGrade, reviewContents, reviewMenu, reviewPrice, nickname, store_storeNo, input);
		//리뷰 값 입력 :평점, 내용, 메뉴, 가격, 닉네임, 매장번호. 사진. 고객번호 
		DbActionReview dbWriteReviewAction = new DbActionReview(reviewGrade, reviewContents, reviewMenu, 
				reviewPrice, nickname, store_storeNo, input, customer_custoNo);
		//테스트
		//DbActionReview dbWriteReviewAction = new DbActionReview(reviewGrade, reviewContents, reviewMenu, reviewPrice, "testNickname", 11, input, 13);
		
		boolean aaa = dbWriteReviewAction.InsertReviewAction(); //
		if(aaa == true){
	         JOptionPane.showMessageDialog(null, nickname +" 님의 리뷰가 입력 되었습니다!");  
	          
	             
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
	
	//리뷰 평점 선택 
	private String SelectedReviewGradeToString() {
		if (rdGrade5.isSelected()) {
			return "5";
		}
		if (rdGrade4.isSelected()) {
			return "4";
		}
		if (rdGrade3.isSelected()) {
			return "3";
		}
		if (rdGrade2.isSelected()) {
			return "2";
		}
		if (rdGrade1.isSelected()) {
			return "1";
		}
		
		return "5";
	}
	
	private String SelectedReviewPriceToStirng() {
		if (rdPriceLess1.isSelected()) {
			return "1만 원 미만";
		}
		if (rdPriceB1A3.isSelected()) {
			return "1~3만 원 미만";
		}
		if (rdPriceB3A5.isSelected()) {
			return "3~5만 원 미만";
		}
		if (rdPriceB5A10.isSelected()) {
			return "5~10만 원 미만";
		}
		if (rdPriceMore10.isSelected()) {
			return "10만 원 이상";
		}
		
		return "1만 원 미만";
	}
	
	
	private boolean checkBlank() {
		// if~else 사용
		if (taRvContents.getText().trim().length()==0) {
			JOptionPane.showMessageDialog(null, "리뷰 내용을 입력해주세요.");
			taRvContents.requestFocus();
		} else {
			return true;
		}
		return false;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("취소");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StoreInformation.main(null);
					frame.dispose();
				}
			});
			button.setForeground(Color.RED);
			button.setBounds(298, 513, 77, 39);
		}
		return button;
	}
	private JLabel getLbStoreName() {
		if (lbStoreName == null) {
			lbStoreName = new JLabel("New label");
			lbStoreName.setForeground(new Color(255, 255, 255));
			lbStoreName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lbStoreName.setHorizontalAlignment(SwingConstants.CENTER);
			lbStoreName.setBounds(89, 25, 306, 48);
		}
		return lbStoreName;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(108, 371, 348, 134);
			scrollPane.setViewportView(getTaRvContents());
		}
		return scrollPane;
	}
	private JTextArea getTaRvContents() {
		if (taRvContents == null) {
			taRvContents = new JTextArea();
			taRvContents.setWrapStyleWord(true);
			taRvContents.setLineWrap(true);
		}
		return taRvContents;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 127, 80));
			panel.setBounds(0, 0, 484, 90);
			panel.setLayout(null);
		}
		return panel;
	}
}//<------


