package com.matzip.functions;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.javalec.function.ShareVar;
import com.matzip.beans.ReviewBean;

public class ReviewAction {


	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
//	int reviewNo, custoNo, storeNo;
//	String reviewGrade, reViewContents, reviewMenu, reviewPrice;
	
	public ReviewAction() {
		// TODO Auto-generated constructor stub
	}
	
//	public ReviewAction(int reviewNo) {
//		super();
//		this.reviewNo = reviewNo;
//	}
//	
//	public ReviewAction(int reviewNo, int custoNo, int storeNo, String reviewGrade, String reViewContents,
//			String reviewMenu, String reviewPrice) {
//		super();
//		this.reviewNo = reviewNo;
//		this.custoNo = custoNo;
//		this.storeNo = storeNo;
//		this.reviewGrade = reviewGrade;
//		this.reViewContents = reViewContents;
//		this.reviewMenu = reviewMenu;
//		this.reviewPrice = reviewPrice;
//	}

	// 검색 결과를 Table로 
	public ArrayList<ReviewBean> searchAction(int storeNo){
		
		ArrayList<ReviewBean> reviewBeanList = new ArrayList<ReviewBean>();
		
		String WhereDefault = "select reviewNo, reviewGrade, reviewContents, review.nickname "
				+ "from Review, customer "
				+ "where custoNo = customer_custoNo and store_storeNo = '";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + storeNo+"'");

            while(rs.next()){
            	
            	int wkReviewNo = rs.getInt(1);
            	String wkReviewGrade = rs.getString(2);
            	String wkReviewContents = rs.getString(3);
            	String wkNickName = rs.getString(4);
            	
            	ReviewBean bean = new ReviewBean(wkReviewNo, wkReviewGrade, wkReviewContents, wkNickName);
            	reviewBeanList.add(bean);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return reviewBeanList;
	}

	// Table을 Click하였을 경우
	public ReviewBean tableClick(int reviewNo) {
		ReviewBean bean = null;
		String WhereDefault = "select review.nickname, reviewMenu, reviewPrice, reviewContents, reviewGrade, reviewImage " + 
				"from Review, customer " + 
				"where custoNo = customer_custoNo " + 
				"and reviewNo = ";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + reviewNo);
            
            if(rs.next()){
            	String wkNickName = rs.getString(1);
            	String wkReviewMenu = rs.getString(2);
            	String wkReviewPrice = rs.getString(3);
            	String wkReviewContents = rs.getString(4);
            	String wkReviewGrade = rs.getString(5);


				Blob blob = rs.getBlob("reviewImage");
				ImageIcon icon = null;
				if (blob != null) {
					InputStream inputStream = blob.getBinaryStream();

					inputStream.close();

					BufferedImage img = ImageIO.read(inputStream);
					Image image = img;
					icon = new ImageIcon(image);
				}
            	
            bean = new ReviewBean(wkNickName, wkReviewMenu, wkReviewPrice, wkReviewContents, wkReviewGrade, icon);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
		return bean;
	}
	
	
}
