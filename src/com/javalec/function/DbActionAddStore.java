package com.javalec.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbActionAddStore {

	private final String url_mySql= ShareVar.DBNAME;
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	int storeno;   // 매장번호 키값 
	String storeName; // 매장명 	
	String storePhon; // 매장 전화번호 
	String storeAddress; // 매장 주소 
	String storeOTime; // 매장 영업시간 
	String foodCategory;	// 음식 종류 
	FileInputStream storeImage; // 매장 이미지 
	String holiday;
	String editer;
	
	
	
	
	
	
	
	public DbActionAddStore() {
		super();
	}
	
	
	//매장입력
	

	
	
	
	
	public DbActionAddStore(String storeName, String storePhon, String storeAddress, String storeOTime,
			String foodCategory, String holiday, String editer) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeOTime = storeOTime;
		this.foodCategory = foodCategory;
		this.holiday = holiday;
		this.editer = editer;
	}







	public DbActionAddStore(String storeName, String storePhon, String storeAddress, String storeOTime, String foodCategory,
		 String holiday, String editer, FileInputStream storeImage) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeOTime = storeOTime;
		this.foodCategory = foodCategory;
		this.storeImage = storeImage;
		this.holiday = holiday;
		this.editer = editer;
	}







	public DbActionAddStore(int storeno, String storeName, String storePhon, String storeAddress, String storeOTime,
			String foodCategory, FileInputStream storeImage) {
		super();
		this.storeno = storeno;
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeOTime = storeOTime;
		this.foodCategory = foodCategory;
		this.storeImage = storeImage;
	}
	
	public DbActionAddStore(String storeName, String storePhon, String storeAddress, String storeOTime, String foodCategory,
			FileInputStream storeImage, String holiday) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeOTime = storeOTime;
		this.foodCategory = foodCategory;
		this.storeImage = storeImage;
		this.holiday = holiday;
	}



	public DbActionAddStore( String storeName, String storePhon, String storeAddress, String oTime,
			String foodCategory, FileInputStream storeImage) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeOTime = oTime;
		this.foodCategory = foodCategory;
		this.storeImage = storeImage;
	}

	

	public DbActionAddStore(String storeName, String storeAddress, String storePhon,  String storeOTime, String foodCategory) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeOTime = storeOTime;
		this.foodCategory = foodCategory;
	}



	public DbActionAddStore(String storeName, String storePhon, String storeAddress, FileInputStream storeImage) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
		this.storeImage = storeImage;
	}

	public DbActionAddStore(int storeno) {
		super();
		this.storeno = storeno;
	}
	
	public DbActionAddStore(String storeName, String storePhon, String storeAddress) {
		super();
		this.storeName = storeName;
		this.storePhon = storePhon;
		this.storeAddress = storeAddress;
	}
	
	// 데이터 불러오기 
	public boolean InsertAction() {
	      PreparedStatement rs = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(url_mySql,id_mysql,pw_mysql);
	          @SuppressWarnings("unused")
	          Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "insert into store(storeName, storeAddress, storePhone, stroreOTime, foodCategory, storeImage, dayOff,editer)";
	          String B = " values (?,?,?,?,?,?,?,?)";
	
	          rs = conn_mysql.prepareStatement(A+B);
	          rs.setString(1, storeName.trim());
	          rs.setString(2, storeAddress.trim());
	          rs.setString(3, storePhon.trim());
	          rs.setString(4, storeOTime);
	          rs.setString(5, foodCategory.trim());
	          rs.setBinaryStream(6, storeImage);
	          rs.setString(7, holiday);
	          rs.setString(8, editer);
	          
	          rs.executeUpdate();

	         conn_mysql.close();
	          
	          
	      } catch (Exception e){	          
	    	  e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
	
}




















	
	
			
			
		
	

	

	
	
	
	
	
	
	
	
	
	



	
	
	
	
			
		
		
		
		
		
		
		
		
			
	
	

