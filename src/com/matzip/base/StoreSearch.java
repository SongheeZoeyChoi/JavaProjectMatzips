package com.matzip.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.ShareVar;

import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class StoreSearch {

	private JFrame frame;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	//
	private final String ur1_mysql = "jdbc:mysql://192.168.0.148:3306/mydb?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	private JComboBox cbSelect;
	private JButton btnAddstore;
	private JButton btnStoreShow;
	private JComboBox cbSort;
	private JLabel lblNewLabel;
	
	String conditionQueryColumn;
	private JButton button;
	private JLabel lbStoreCount;
	private JPanel panel_1;
	private JLabel lbSelectedStore;
	private JTextField textField;

	// Table환경 정의
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreSearch window = new StoreSearch();
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
	public StoreSearch() {
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
				TableInit();
				SearchAction();
			}
		});
		frame.setTitle("맛집 검색");
		frame.setBounds(100, 100, 626, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnAddstore());
		frame.getContentPane().add(getBtnStoreShow());
		frame.getContentPane().add(getCbSort());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getButton());
		frame.getContentPane().add(getLbStoreCount());
		frame.getContentPane().add(getPanel_1());
		frame.getContentPane().add(getLbSelectedStore());
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setToolTipText("");
			tfSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			tfSearch.setBounds(156, 6, 317, 48);
			tfSearch.setBackground(new Color(255, 250, 250));
			tfSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 10) {
						btnSearch.doClick();
					}
				}
			});
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("맛집쓰!");
			btnSearch.setBounds(485, 6, 101, 48);
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchBtn();
				}
			});
			btnSearch.setFont(new Font("Lantinghei SC", Font.BOLD, 25));
		}
		return btnSearch;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 100, 564, 321);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = Inner_Table.getSelectedRow();
					ShareVar.ROW = Integer.parseInt((String) (Inner_Table.getModel().getValueAt(row, 0)));
					
					int storeColumn = Inner_Table.getSelectedColumn();
					lbSelectedStore.setText((String) Inner_Table.getModel().getValueAt(row, 1));
				}
			});

			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table); // <------*****환경정의 꼭 하기
		}
		return Inner_Table;
	}

//
	private void TableInit() {

		Outer_Table.addColumn("매장번호");
		Outer_Table.addColumn("매장명");
		Outer_Table.addColumn("주소");
		Outer_Table.addColumn("평점");
		Outer_Table.addColumn("후기 수");
		Outer_Table.setColumnCount(5);

		int i = Outer_Table.getRowCount(); // 몇 줄인지 알려줌
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int colIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(colIndex);
		int width = 80;
		col.setPreferredWidth(width);

		colIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(colIndex);
		width = 120;
		col.setPreferredWidth(width);

		colIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(colIndex);
		width = 180;
		col.setPreferredWidth(width);

		colIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(colIndex);
		width = 80;
		col.setPreferredWidth(width);

		colIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(colIndex);
		width = 80;
		col.setPreferredWidth(width);

//
	}//

	private JComboBox getCbSelect() {
		if (cbSelect == null) {
			cbSelect = new JComboBox();
			cbSelect.setBounds(38, 17, 105, 27);
			cbSelect.setModel(new DefaultComboBoxModel(new String[] { "매장명", "주소" }));
		}
		return cbSelect;
	}

	private JButton getBtnAddstore() {
		if (btnAddstore == null) {
			btnAddstore = new JButton("+");
			btnAddstore.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AddStore.main(null);
					frame.dispose();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					textField.setVisible(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					textField.setVisible(false);
				}
			});
			btnAddstore.setFont(new Font("ITF Devanagari", Font.PLAIN, 20));
			btnAddstore.setBounds(505, 433, 92, 36);
		}
		return btnAddstore;
	}

	private JButton getBtnStoreShow() {
		if (btnStoreShow == null) {
			btnStoreShow = new JButton("맛집보기");
			btnStoreShow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(ShareVar.ROW == 0) {
						JOptionPane.showMessageDialog(null, "검색할 매장을 선택해 주세요!");
					}else {
					StoreInformation.main(null);
					frame.dispose();
					}
				}
			});

			btnStoreShow.setFont(new Font("ITF Devanagari Marathi", Font.PLAIN, 20));
			btnStoreShow.setBounds(321, 433, 150, 77);
		}
		return btnStoreShow;
	}
//
    
	private void searchBtn() {
		int i = cbSelect.getSelectedIndex();
		    
		
		conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "storeName";
			break;

		case 1:
			conditionQueryColumn = "storeAddress";
			break;

		}
		
		
		
		TableInit();
		ConditionQueryAction(conditionQueryColumn);
		Countdown();
	}//
		// 조건검색

	private void ConditionQueryAction(String cqc) {
		int Count = 0;
		String whereDefault = null;
		TableInit();

//		if (cbSort.getSelectedIndex() == 0) {
//			// 매장번호 정렬 코드찾기 (기본)
//			SearchAction();
//			whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' "
//					+ "from store left outer join review " + "on store_storeNo = storeNo " + "where " + cqc + " like '%"
//					+ tfSearch.getText() + "%' " + "group by storeNo, storeName " + "order by storeNo;";
//
//		} // 평점순 정렬
//		else if (cbSort.getSelectedIndex() == 1) { // SelectCbOrderByGradeDesc();
//			whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' "
//					+ "from store left outer join review " + "on store_storeNo = storeNo " + "where " + cqc + " like '%"
//					+ tfSearch.getText() + "%' " + "group by storeNo, storeName " + "order by grade desc;";
//		} // 후기 정렬
//		else if (cbSort.getSelectedIndex() == 2) {
//			// SelectCbOrderByReviewCountDesc();
//			whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' "
//					+ "from store left outer join review " + "on store_storeNo = storeNo " + "where " + cqc + " like '%"
//					+ tfSearch.getText() + "%' " + "group by storeNo, storeName " + "order by reviewcount desc;";
//		}

		//조건검색 디폴트 매장번호 
		
		if(cqc == null) {

			 whereDefault =  "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' \n"
						+ "from store left outer join review \n" + "on store_storeNo = storeNo \n"
						+ "group by storeNo, storeName\n" + "order by storeNo; ";
		}else {

			 whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' \n"
				+ "from store left outer join review \n" + "on store_storeNo = storeNo \n" + "where " + cqc + " like '%" + tfSearch.getText() + "%' "
				+ "group by storeNo, storeName\n" + "order by storeNo; ";
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(ur1_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };
				Outer_Table.addRow(qTxt);
				Count++;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		lbStoreCount.setText(Integer.toString(Count)+"개의 맛집");
	}//

	// StoreNo 순으로 정렬 (조건불포)
	private void SearchAction() {
		String whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' \n"
				+ "from store left outer join review \n" + "on store_storeNo = storeNo \n"
				+ "group by storeNo, storeName\n" + "order by storeNo; ";

		int Count = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(ur1_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };
				Outer_Table.addRow(qTxt);
				Count++;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		lbStoreCount.setText(Integer.toString(Count)+"개의 맛집");
	}//

	// 평점순 정렬 (조건불포)
	private void SelectCbOrderByGradeDesc(String cqc) {
		String whereDefault;
		if(cqc == null) {

			 whereDefault =  "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' \n" + 
					"from store left outer join review \n" + 
					"on store_storeNo = storeNo \n" + 
					"group by storeNo, storeName\n" + 
					"order by grade desc;";
		}else {

			 whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' "
					+ "from store left outer join review " + "on store_storeNo = storeNo " + "where " + cqc + " like '%"
					+ tfSearch.getText() + "%' " + "group by storeNo, storeName " + "order by grade desc;";	
		}

		int Count = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(ur1_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };
				Outer_Table.addRow(qTxt);
				Count++;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		lbStoreCount.setText(Integer.toString(Count)+"개의 맛집");
	}//

	// 후기순 정렬 (조건불포)
	private void SelectCbOrderByReviewCountDesc(String cqc) {
		String whereDefault;
		if(cqc == null) {

			 whereDefault =  "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' \n" + 
					"from store left outer join review \n" + 
					"on store_storeNo = storeNo \n" + 
					"group by storeNo, storeName\n" + 
					"order by reviewcount desc;";
		}else {

			 whereDefault = "select storeNo, storeName, storeAddress, round(avg(reviewGrade),1) as 'GRADE', count(Review.store_storeNo) as 'reviewcount' "
					+ "from store left outer join review " + "on store_storeNo = storeNo " + "where " + cqc + " like '%"
					+ tfSearch.getText() + "%' " + "group by storeNo, storeName " + "order by reviewcount desc;";	
		}


		int Count = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(ur1_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };
				Outer_Table.addRow(qTxt);
				Count++;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		lbStoreCount.setText(Integer.toString(Count)+"개의 맛집");
	}//

	private JComboBox getCbSort() {
		if (cbSort == null) {
			cbSort = new JComboBox();
			cbSort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Countdown();
					

				}
			});
			cbSort.setModel(new DefaultComboBoxModel(new String[] { "매장번호", "평점순", "후기순" }));
			cbSort.setBounds(486, 71, 107, 27);
		}
		return cbSort;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("정렬");
			lblNewLabel.setBounds(455, 76, 37, 16);
		}
		return lblNewLabel;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("로그아웃");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
				}
			});
			button.setBounds(505, 474, 92, 36);
		}
		return button;
	}//
	
	private void Countdown() {
	
		
		int i = cbSort.getSelectedIndex();

//		String conditionQueryColumn = "";
//		switch(i){
//		case 0:
//		conditionQueryColumn = "storeNo";
//	        break;	
//		case 1:
//		conditionQueryColumn = "grade";
//        break;		
//		
//		case 2:
//		conditionQueryColumn = "reviewcount";
//		break;
//		
//		}
//		TableInit();
//		ConditionQueryAction(conditionQueryColumn);

		// btnSearch.doClick();

		if (cbSort.getSelectedIndex() == 0) {
			// 매장번호 정렬 코드찾기 (기본)
			TableInit();
			if(tfSearch.getText().length()==0) {
				ConditionQueryAction(null);
			} else {
				ConditionQueryAction(conditionQueryColumn);
			}

			
          
		} else if (cbSort.getSelectedIndex() == 1) {
			// 평점순 정렬
			TableInit();
			
			if(tfSearch.getText().length()==0) {
				SelectCbOrderByGradeDesc(null);
			} else {
				SelectCbOrderByGradeDesc(conditionQueryColumn);
			}

		} else if (cbSort.getSelectedIndex() == 2) {
			// 후기 정렬
			TableInit();
			if(tfSearch.getText().length()==0) {
				SelectCbOrderByReviewCountDesc(null);
			} else {
				SelectCbOrderByReviewCountDesc(conditionQueryColumn);
			}

		

		}
	}
	private JLabel getLbStoreCount() {
		if (lbStoreCount == null) {
			lbStoreCount = new JLabel("검색결과");
			lbStoreCount.setBounds(29, 76, 143, 16);
		}
		return lbStoreCount;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(255, 127, 80));
			panel_1.setBounds(0, 0, 626, 60);
			panel_1.add(getCbSelect());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JLabel getLbSelectedStore() {
		if (lbSelectedStore == null) {
			lbSelectedStore = new JLabel("");
			lbSelectedStore.setHorizontalAlignment(SwingConstants.CENTER);
			lbSelectedStore.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lbSelectedStore.setBounds(29, 433, 280, 77);
		}
		return lbSelectedStore;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setToolTipText("");
			textField.setEditable(false);
			textField.setVisible(false);
			textField.setForeground(new Color(255, 255, 255));
			textField.setBackground(new Color(255, 127, 80));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("새로운 매장 등록하기!");
			textField.setBounds(483, 400, 135, 32);
			textField.setColumns(10);
		}
		return textField;
	}
}//
