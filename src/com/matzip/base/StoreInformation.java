package com.matzip.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.ShareVar;
import com.matzip.beans.ReviewBean;
import com.matzip.beans.StoreBean;
import com.matzip.functions.ReviewAction;
import com.matzip.functions.StoreAction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextArea;

public class StoreInformation {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JLabel lblReview;
	private JTextField tfNickname;
	private JTextField tfMenu;
	private JTextField tfPrice;
	private JTextField tfPhone;
	private JLabel label_1;
	private JTextField tfFoodCategory;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField tfOTime;
	private JLabel label_5;
	private JTextField tfDayOff;
	private JLabel lblNewLabel_2;
	private JButton btnWriteReview;
	private JScrollPane scrollPane;
	private JTextField tfGrade;
	private JLabel label_6;
	private JButton btnBack;
	private JTable innerTable;
	private JTextField tfEditor;
	private JLabel lbImage;
	private JLabel tfStoreName;
	private JButton btnRemove;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JLabel lb5;
	private JLabel lbReviewImage;
	private JScrollPane scrollPane_1;
	private JTextArea tfContents;
	private JScrollPane scrollPane_2;
	private JTextArea tfAddress;
	private JPanel panel_1;
	private JPanel panel_1_1;


	private final DefaultTableModel outerTable = new DefaultTableModel();
	private int storeNo;
	
	ImageIcon emptyStar = new ImageIcon("/Users/tj/Documents/csh8881/Matzip's/emptyStar.png");
	Image emptyStarImg = emptyStar.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
	ImageIcon filledStar = new ImageIcon("/Users/tj/Documents/csh8881/Matzip's/filledStar.png");
	Image filledStarImg = filledStar.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
	ImageIcon defaultStore = new ImageIcon("/Users/tj/Documents/csh8881/Matzip's/defaultStore.png");
	Image defaultStoreImg = defaultStore.getImage().getScaledInstance(167, 186, Image.SCALE_SMOOTH);
	ImageIcon defaultReview = new ImageIcon("/Users/tj/Documents/csh8881/Matzip's/defaultReview.png");
	Image defaultReviewImg = defaultReview.getImage().getScaledInstance(130, 149, Image.SCALE_SMOOTH);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreInformation window = new StoreInformation();
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
	public StoreInformation() {
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
				storeNo = ShareVar.ROW;
				storeInit();
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("매장정보");
		frame.setBounds(100, 100, 914, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //모니터중간배치 
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getSeparator());
		frame.getContentPane().add(getTfNickname());
		frame.getContentPane().add(getTfMenu());
		frame.getContentPane().add(getTfPrice());
		frame.getContentPane().add(getTfPhone());
		frame.getContentPane().add(getLabel_1());
		frame.getContentPane().add(getTfFoodCategory());
		frame.getContentPane().add(getLabel_2());
		frame.getContentPane().add(getLabel_3());
		frame.getContentPane().add(getLabel_4());
		frame.getContentPane().add(getTfOTime());
		frame.getContentPane().add(getLabel_5());
		frame.getContentPane().add(getTfDayOff());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnWriteReview());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfGrade());
		frame.getContentPane().add(getLabel_6());
		frame.getContentPane().add(getBtnBack());
		frame.getContentPane().add(getTfEditor());
		frame.getContentPane().add(getLbImage());
		frame.getContentPane().add(getTfStoreName());
		frame.getContentPane().add(getBtnRemove());
		frame.getContentPane().add(getLb1());
		frame.getContentPane().add(getLb2());
		frame.getContentPane().add(getLb3());
		frame.getContentPane().add(getLb4());
		frame.getContentPane().add(getLb5());
		frame.getContentPane().add(getLbReviewImage());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getScrollPane_2());
		frame.getContentPane().add(getPanel_1());
		frame.getContentPane().add(getPanel_1_1());
	}

	// ==============================
	// ==           메소드           ==
	// ==============================
	// 화면 초기화
	private void storeInit() {
		StoreAction storeAction = new StoreAction(storeNo);
		if(storeAction.isEditor()) {
			//btnModify.setVisible(true);
			btnRemove.setVisible(true);
		} else {
			//btnModify.setVisible(false);
			btnRemove.setVisible(false);
		}
		fillInformation();
	}
	
	// 리뷰 테이블 초기화
	private void tableInit() {
		int i = outerTable.getRowCount();

		outerTable.addColumn("no.");
		outerTable.addColumn("닉네임");
		outerTable.addColumn("평점");
		outerTable.addColumn("내용");
		outerTable.setColumnCount(4);

		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_LAST_COLUMN);

		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 5;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 5;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);
	}
	
	// 전체 검색결과를 Table로
	private void searchAction() {
		ReviewAction reviewAction = new ReviewAction();
		ArrayList<ReviewBean> beanList = reviewAction.searchAction(storeNo);

		int listCount = beanList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getReviewNo());
			String[] qTxt = { temp, beanList.get(index).getNickName(), beanList.get(index).getReviewGrade(), beanList.get(index).getReviewContents() };
			outerTable.addRow(qTxt);
		}

	}
	
	// Table에서 Row를 Click후 검색
	private void tableClick() {
		int i = innerTable.getSelectedRow();
		String tkSequence = (String) innerTable.getValueAt(i, 0);
		int wkSequence = Integer.parseInt(tkSequence);

		ReviewAction reviewAction = new ReviewAction();
		ReviewBean reviewBean = reviewAction.tableClick(wkSequence);

		tfNickname.setText(reviewBean.getNickName());
		tfContents.setText(reviewBean.getReviewContents());
		tfMenu.setText(reviewBean.getReviewMenu());
		tfPrice.setText(reviewBean.getReviewPrice());
		
		if(reviewBean.getReviewImage() != null) {
			Image reviewImage = reviewBean.getReviewImage().getImage().getScaledInstance(144, 144, Image.SCALE_SMOOTH);
			lbReviewImage.setIcon(new ImageIcon(reviewImage));
			lbReviewImage.setHorizontalAlignment(SwingConstants.CENTER);
		} else {
			lbReviewImage.setIcon(new ImageIcon(defaultReviewImg));
			lbReviewImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		drawGrade(Integer.parseInt(reviewBean.getReviewGrade()));

	}
	
	private void drawGrade(int grade) {
		JLabel[] lb = {lb1, lb2, lb3, lb4, lb5};
		for(int i=grade-1; i<5; i++) {
			lb[i].setIcon(new ImageIcon(emptyStarImg));
		}
		for(int i=0; i<grade; i++) {
			lb[i].setIcon(new ImageIcon(filledStarImg));
		}
	}

	private void fillInformation() {
		StoreAction storeAction = new StoreAction(storeNo);
		StoreBean storeBean = storeAction.fillStoreInfo();
		
		tfEditor.setText(storeBean.getEditor());
		tfStoreName.setText(storeBean.getStoreName());
		tfAddress.setText(storeBean.getStoreAddress());
		tfFoodCategory.setText(storeBean.getFoodCategory());
		tfOTime.setText(storeBean.getStoreOTime());
		tfPhone.setText(storeBean.getStorePhone());
		tfDayOff.setText(storeBean.getDayOff());
		
		if(storeBean.getImgIcon() != null) {
			Image storeImage = storeBean.getImgIcon().getImage().getScaledInstance(167, 186, Image.SCALE_SMOOTH);
			lbImage.setIcon(new ImageIcon(storeImage));
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		} else {
			lbImage.setIcon(new ImageIcon(defaultStoreImg));
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		tfGrade.setText(storeAction.getGrade());
	}
	
	private void removeAction() {
		int result = JOptionPane.showConfirmDialog(null, "정말로 "+tfStoreName.getText()+"의 정보를 삭제하시겠습니까?");
		if(result == 0) {
			StoreAction storeAction = new StoreAction(storeNo);
			if(storeAction.removeAction()) {
				JOptionPane.showMessageDialog(null, "삭제하였습니다.");
				StoreSearch.main(null);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "삭제에 실패했습니다.");
			}
		}
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("주소");
			lblNewLabel_1.setBounds(208, 237, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(454, 94, 6, 407);
		}
		return separator;
	}

	private JLabel getLblReview() {
		if (lblReview == null) {
			lblReview = new JLabel("Review");
			lblReview.setForeground(new Color(255, 255, 255));
			lblReview.setBounds(33, 28, 112, 34);
			lblReview.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		}
		return lblReview;
	}

	private JTextField getTfNickname() {
		if (tfNickname == null) {
			tfNickname = new JTextField();
			tfNickname.setEditable(false);
			tfNickname.setHorizontalAlignment(SwingConstants.CENTER);
			tfNickname.setColumns(10);
			tfNickname.setBounds(633, 295, 110, 26);
		}
		return tfNickname;
	}

	private JTextField getTfMenu() {
		if (tfMenu == null) {
			tfMenu = new JTextField();
			tfMenu.setHorizontalAlignment(SwingConstants.CENTER);
			tfMenu.setEditable(false);
			tfMenu.setText("-");
			tfMenu.setColumns(10);
			tfMenu.setBounds(633, 323, 130, 26);
		}
		return tfMenu;
	}

	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setText("-");
			tfPrice.setEditable(false);
			tfPrice.setHorizontalAlignment(SwingConstants.CENTER);
			tfPrice.setColumns(10);
			tfPrice.setBounds(763, 323, 123, 26);
		}
		return tfPrice;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(135, 351, 275, 26);
		}
		return tfPhone;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("전화번호");
			label_1.setBounds(62, 356, 61, 16);
		}
		return label_1;
	}

	private JTextField getTfFoodCategory() {
		if (tfFoodCategory == null) {
			tfFoodCategory = new JTextField();
			tfFoodCategory.setEditable(false);
			tfFoodCategory.setColumns(10);
			tfFoodCategory.setBounds(208, 191, 202, 34);
		}
		return tfFoodCategory;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("음식종류");
			label_2.setBounds(208, 171, 61, 16);
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("편의정보");
			label_3.setBounds(39, 322, 61, 16);
		}
		return label_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("영업시간");
			label_4.setBounds(62, 389, 61, 16);
		}
		return label_4;
	}

	private JTextField getTfOTime() {
		if (tfOTime == null) {
			tfOTime = new JTextField();
			tfOTime.setEditable(false);
			tfOTime.setBounds(135, 384, 275, 26);
			tfOTime.setColumns(10);
		}
		return tfOTime;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("휴일");
			label_5.setBounds(62, 422, 61, 16);
		}
		return label_5;
	}

	private JTextField getTfDayOff() {
		if (tfDayOff == null) {
			tfDayOff = new JTextField();
			tfDayOff.setEditable(false);
			tfDayOff.setColumns(10);
			tfDayOff.setBounds(135, 417, 275, 26);
		}
		return tfDayOff;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Edited by");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lblNewLabel_2.setBounds(299, 50, 49, 16);
		}
		return lblNewLabel_2;
	}

	private JButton getBtnWriteReview() {
		if (btnWriteReview == null) {
			btnWriteReview = new JButton("리뷰작성");
			btnWriteReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Review.main(null);
					frame.dispose();
				}
			});
			btnWriteReview.setBounds(826, 94, 60, 34);
		}
		return btnWriteReview;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(491, 140, 395, 140);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JTextField getTfGrade() {
		if (tfGrade == null) {
			tfGrade = new JTextField();
			tfGrade.setEditable(false);
			tfGrade.setColumns(10);
			tfGrade.setBounds(208, 125, 202, 34);
		}
		return tfGrade;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("평점");
			label_6.setBounds(208, 105, 61, 16);
		}
		return label_6;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StoreSearch.main(null);
					frame.dispose();
				}
			});
			btnBack.setBounds(805, 456, 81, 45);
		}
		return btnBack;
	}

	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==1) {
						tableClick();
					}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable); // <--***************************************************
		}
		return innerTable;
	}

	private JTextField getTfEditor() {
		if (tfEditor == null) {
			tfEditor = new JTextField();
			tfEditor.setEditable(false);
			tfEditor.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			tfEditor.setBounds(344, 45, 61, 26);
			tfEditor.setColumns(10);
		}
		return tfEditor;
	}

	private JLabel getLbImage() {
		if (lbImage == null) {
			lbImage = new JLabel("");
			lbImage.setIcon(new ImageIcon(defaultStoreImg));
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbImage.setBounds(29, 115, 167, 186);
		}
		return lbImage;
	}

	private JLabel getTfStoreName() {
		if (tfStoreName == null) {
			tfStoreName = new JLabel("New label");
			tfStoreName.setForeground(new Color(255, 255, 255));
			tfStoreName.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			tfStoreName.setBounds(29, 25, 240, 46);
		}
		return tfStoreName;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("매장삭제");
			btnRemove.setForeground(Color.RED);
			btnRemove.setVisible(false);
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeAction();
				}
			});
			btnRemove.setBounds(324, 456, 88, 45);
		}
		return btnRemove;
	}
	private JLabel getLb1() {
		if (lb1 == null) {
			lb1 = new JLabel("");
			lb1.setHorizontalAlignment(SwingConstants.CENTER);
			lb1.setBounds(763, 297, 24, 24);
		}
		return lb1;
	}
	private JLabel getLb2() {
		if (lb2 == null) {
			lb2 = new JLabel("");
			lb2.setHorizontalAlignment(SwingConstants.CENTER);
			lb2.setBounds(787, 297, 24, 24);
		}
		return lb2;
	}
	private JLabel getLb3() {
		if (lb3 == null) {
			lb3 = new JLabel("");
			lb3.setHorizontalAlignment(SwingConstants.CENTER);
			lb3.setBounds(811, 297, 24, 24);
		}
		return lb3;
	}
	private JLabel getLb4() {
		if (lb4 == null) {
			lb4 = new JLabel("");
			lb4.setHorizontalAlignment(SwingConstants.CENTER);
			lb4.setBounds(835, 297, 24, 24);
		}
		return lb4;
	}
	private JLabel getLb5() {
		if (lb5 == null) {
			lb5 = new JLabel("");
			lb5.setHorizontalAlignment(SwingConstants.CENTER);
			lb5.setBounds(859, 297, 24, 24);
		}
		return lb5;
	}
	private JLabel getLbReviewImage() {
		if (lbReviewImage == null) {
			lbReviewImage = new JLabel("");
			lbReviewImage.setBackground(new Color(255, 250, 250));
			lbReviewImage.setIcon(new ImageIcon(defaultReviewImg));
			lbReviewImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbReviewImage.setBounds(491, 298, 130, 149);
		}
		return lbReviewImage;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(633, 361, 251, 86);
			scrollPane_1.setViewportView(getTfContents());
		}
		return scrollPane_1;
	}
	private JTextArea getTfContents() {
		if (tfContents == null) {
			tfContents = new JTextArea();
			tfContents.setWrapStyleWord(true);
			tfContents.setLineWrap(true);
			tfContents.setEditable(false);
		}
		return tfContents;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(208, 265, 197, 45);
			scrollPane_2.setViewportView(getTfAddress());
		}
		return scrollPane_2;
	}
	private JTextArea getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextArea();
			tfAddress.setEditable(false);
			tfAddress.setWrapStyleWord(true);
			tfAddress.setLineWrap(true);
		}
		return tfAddress;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 127, 80));
			panel_1.setBounds(0, 0, 460, 82);
			panel_1.setLayout(null);
		}
		return panel_1;
	}
	private JPanel getPanel_1_1() {
		if (panel_1_1 == null) {
			panel_1_1 = new JPanel();
			panel_1_1.setBackground(new Color(255, 127, 80));
			panel_1_1.setBounds(454, 0, 460, 82);
			panel_1_1.setLayout(null);
			panel_1_1.add(getLblReview());
		}
		return panel_1_1;
	}
}
