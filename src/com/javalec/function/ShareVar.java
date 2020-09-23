package com.javalec.function;

	//환경정의 
public class ShareVar {
	public static String DBNAME = "jdbc:mysql://192.168.0.148/mydb?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static String DBUSER = "root";
	public static String DBPASS = "qwer1234";
	public static int Reviewfilename = 0; // File name이 달라야 즉각 보여주기가 가능하여
									//ShareVar에서 int값으로 정의하여 계속 증가하게 하여 filename으로 사용후 삭제
	
	public static int ROW = 0;
	
	// 로그인 값을 넣고 static으로 넣어줌. 
	public static String GET_NICKNAME;

	public static int CUSTO_CUSTONO;
	
	//store 
	public static int Storefilename=0;
	 //public static String NICKNAME = getNickName;
	
	
	
	
	
}
