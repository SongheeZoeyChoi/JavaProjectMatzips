package com.matzip.functions;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.javalec.function.ShareVar;
import com.matzip.beans.StoreBean;

public class StoreAction {

	private final String url_mysql = ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;

	int storeNo;
	String storeName, storePhone, storeOTime, storeAddress, foodCategory, editor, dayOff;
	InputStream storeImage;

	public StoreAction() {
		// TODO Auto-generated constructor stub
	}

	public StoreAction(int storeNo) {
		super();
		this.storeNo = storeNo;
	}

	public StoreAction(int storeNo, String storeName, String storePhone, String storeOTime, String storeAddress,
			String foodCategory, String editor, String dayOff, InputStream storeImage) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeOTime = storeOTime;
		this.storeAddress = storeAddress;
		this.foodCategory = foodCategory;
		this.editor = editor;
		this.dayOff = dayOff;
		this.storeImage = storeImage;
	}

	public boolean isEditor() {
		String editor = "";

		String whereDefault = "select editer from store where storeNo = ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지이름으로 불러오기
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // 커넥트
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault + storeNo);

			if (rs.next()) {
				editor = rs.getString(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(ShareVar.GET_NICKNAME.equals(editor)) {
			return true;
		} else {
			return false;
		}
	}
	
	public StoreBean fillStoreInfo() {

		StoreBean storeBean = null;

		String whereDefault = "SELECT storeName, storePhone, stroreOTime, storeAddress, foodCategory, editer, dayOff, storeImage FROM store where storeNo = ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지이름으로 불러오기
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // 커넥트
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault + storeNo);

			if (rs.next()) {
				String wkName = rs.getString(1);
				String wkPhone = rs.getString(2);
				String wkOTime = rs.getString(3);
				String wkAddress = rs.getString(4);
				String wkCategory = rs.getString(5);
				String wkEditor = rs.getString(6);
				String wkDayOff = rs.getString(7);

				Blob blob = rs.getBlob("storeImage");
				ImageIcon icon = null;
				if (blob != null) {
					InputStream inputStream = blob.getBinaryStream();

					inputStream.close();

					BufferedImage img = ImageIO.read(inputStream);
					Image image = img;
					icon = new ImageIcon(image);
				}

				storeBean = new StoreBean(wkName, wkPhone, wkOTime, wkAddress, wkCategory, wkEditor, wkDayOff, icon);
				
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return storeBean;

	}
	
	// 수정
	public boolean modifyAction() {
		  PreparedStatement ps = null;

			String whereDefault = "SELECT storeName=?, storePhone=?, stroreOTime=?, storeAddress=?, foodCategory=?, dayOff=?, storeImage=? FROM store where storeNo = ";
			
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      ps = conn_mysql.prepareStatement(whereDefault + storeNo);
		      
		      ps.setString(1, storeName);
		      ps.setString(2, storePhone);
		      ps.setString(3, storeOTime);
		      ps.setString(4, storeAddress);
		      ps.setString(5, foodCategory);
		      ps.setString(6, dayOff);
		      ps.setBinaryStream(7, storeImage);
		      ps.executeUpdate();
		
		      conn_mysql.close();
		      
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}

	// 삭제
	public boolean removeAction() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          ps = conn_mysql.prepareStatement("delete from store where storeNo = " + storeNo);
	          
	          ps.executeUpdate();
	
	          conn_mysql.close();
	          
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
	public String getGrade() {
		
		String grade = null;
		
		String whereDefault = "select truncate(avg(reviewGrade), 1) from store, review " + 
				"where storeNo = store_storeNo " + 
				"and storeNo = ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지이름으로 불러오기
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // 커넥트
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault + storeNo);

			if (rs.next()) {
				grade = rs.getString(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(grade == null) {
			grade = "0";
		}

		return grade;
		
	}
	public boolean checkPhone(String Phoncheck) {

		String WhereDefault = "select storephone from store where storephone = '";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + Phoncheck + "'");

			if (rs.next()) {
				conn_mysql.close();
				return false;
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
