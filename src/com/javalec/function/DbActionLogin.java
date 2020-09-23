package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class DbActionLogin {
	
	private final String url_mysql = ShareVar.DBNAME; // 아까 sharevar에 정햇기 떄문에 불러옴 
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	//Field
	int custoNo;
	String nickname;
	String email;
	String password;
	// 전역변수 
	String searchEmail;

	//Constructor
	public DbActionLogin() {
		// TODO Auto-generated constructor stub
	}

	//값 포함 Constructor
	public DbActionLogin(int custoNo, String nickname, String email, String password) {
		super();
		this.custoNo = custoNo;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}
	
	//searchEmail 
	public DbActionLogin(String searchEmail) {
		super();
		this.searchEmail = searchEmail;
	}

	public ArrayList<LoginBean> GetCustoInfo() { //-------
			
		ArrayList<LoginBean> LoginBeanList = new ArrayList<LoginBean>(); // ArrayList 생성 
		
		String searchlogin = "select custoNo, nickname, email, password from customer " ; // SQL문 전송 
		
		// String searchlogin2 = "where email = '" + searchEmail + "';"; // searchEmail 변수, constructor 생성 
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(searchlogin);  // DB 데이터 가져오기 
			
			while(rs.next()) {// 다음 행이 있으면 (true)  
				int wkCustoNo = rs.getInt(1);
	        	String wkNickname = rs.getString(2);
	        	String wkEmail = rs.getString(3);
	        	String wkPassword = rs.getString(4);
	        	
	        	LoginBean loginBean = new LoginBean(wkCustoNo, wkNickname, wkEmail, wkPassword); //LoginBean 타입을 만들어서 배열에 넣음
	        	LoginBeanList.add(loginBean);//한방에 넣기 위해 loginBean 만들어서 배열 넣기  
	        	
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return LoginBeanList; // 로그인할때 필요한 고객정보배열로 가져오기 
		
	
	}

	
	
} //<----
