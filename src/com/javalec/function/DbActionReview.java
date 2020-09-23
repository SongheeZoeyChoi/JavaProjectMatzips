package com.javalec.function;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DbActionReview {
	
	private final String url_mysql = ShareVar.DBNAME; // 아까 sharevar에 정햇기 떄문에 불러옴 
	private final String id_mysql = ShareVar.DBUSER;
	private final String pw_mysql = ShareVar.DBPASS;
	
	//Field 
	int reviewNo;  
	String reviewGrade;
	String reviewContents;
	String reviewMenu;
	String reviewPrice;
	String nickname = ShareVar.GET_NICKNAME;
	int store_storeNo;
	String reviewInsertTime;
	// 리뷰 이미지 파일 필드
	FileInputStream reviewImagefile;	
	int	customer_custoNo;
	
	//Constructor
	
	public DbActionReview() {
		// TODO Auto-generated constructor stub
	}

	//전체 값 생성자
	public DbActionReview(int reviewNo, String reviewGrade, String reviewContents, String reviewMenu,
			String reviewPrice, String nickname, int store_storeNo, String reviewInsertTime,
			FileInputStream reviewImagefile) {
		super();
		this.reviewNo = reviewNo;
		this.reviewGrade = reviewGrade;
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.nickname = nickname;
		this.store_storeNo = store_storeNo;
		this.reviewInsertTime = reviewInsertTime;
		this.reviewImagefile = reviewImagefile;
	}

	// 리뷰입력 생성자 리뷰 값 입력1 : 평점, 내용, 메뉴, 가격, 닉네임, 매장번호. 사진.
	public DbActionReview(String reviewGrade, String reviewContents, String reviewMenu, String reviewPrice,
			String nickname, int store_storeNo, FileInputStream reviewImagefile) {
		super();
		this.reviewGrade = reviewGrade;
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.nickname = nickname;
		this.store_storeNo = store_storeNo;
		this.reviewImagefile = reviewImagefile;
	}
	
	// 리뷰입력 생성자 리뷰 값 입력2 : 평점, 내용, 메뉴, 가격, 닉네임, 매장번호. 사진. 고객번호 
	public DbActionReview(String reviewGrade, String reviewContents, String reviewMenu, String reviewPrice,
			String nickname, int store_storeNo, FileInputStream reviewImagefile, int customer_custoNo) {
		super();
		this.reviewGrade = reviewGrade;
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.nickname = nickname;
		this.store_storeNo = store_storeNo;
		this.reviewImagefile = reviewImagefile;
		this.customer_custoNo = customer_custoNo;
	}
	
	//Method
	// 입력 메소드 
	public boolean InsertReviewAction() {
		PreparedStatement ps = null; //  PreparedStatement(java.sql) : SQL 명령어를 자바 스타일로 바꿔주는 것. 
		// 에러걸렸을떄 처리 try-catch
		// 데이터 보내기 
		try {   // 오류 안났을때 
			Class.forName("com.mysql.cj.jdbc.Driver"); //  라이브러리에 드라이브 추가했던거 불러와서 / 이름 똑같아야함.  
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // 어디로 연결? 환경설정한 작업 데이터베이스 연결 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			//이미지, 평점, 내용, 메뉴, 가격,닉네임, 매장번호,등록시간 
			String A = "insert into review(reviewImage, reviewGrade, reviewContents, reviewMenu, "
					+ "reviewPrice, nickname, store_storeNo, customer_custoNo, reviewWriteTime) "; //  SQL에 넣을 문장 쓰기 / name 뒤에 띄어쓰기 안되어있으면 에러걸림! mySQL 에서 쓰는걸 넣는거기때문에
			String B = "values(?, ?, ?, ?, ?, ?, ?, ?, now())"; // ? 하나있으면 setString(1, 1개. ?,? 두개 있으면 2번 있어야하고.   / now() 는 자동으로 들어가니까 밑 안써도됌./ DATE/ TIME 따로 해도 나옴! 
			
			ps = conn_mysql.prepareStatement(A + B);  // prepareStatement(java.sql로 선) : 자바가 이해할 수 있는 언어로 바꿔줌 
			ps.setBinaryStream(1, reviewImagefile); // name 넣어주기 
			ps.setString(2, reviewGrade.trim());	// Telno
			ps.setString(3, reviewContents.trim());	
			ps.setString(4, reviewMenu.trim());	
			ps.setString(5, reviewPrice.trim());	
			ps.setString(6, nickname.trim());
			ps.setInt(7, store_storeNo);
			ps.setInt(8, customer_custoNo);
						
			ps.executeUpdate(); // 실행 
			
			conn_mysql.close(); // 커넥션 끊어 해주기 
			
			
		}catch(Exception e) { // 오류 났을떄 
			e.printStackTrace(); // 에러보여주기 
			// 에러 걸렸을 떄 
			return false;
		}
		
		// 에러 안걸리면 
		return true;
	
	}



	


	
	

	
	
	
	
	
	
} //<-----
