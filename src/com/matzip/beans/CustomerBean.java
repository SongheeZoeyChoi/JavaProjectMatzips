package com.matzip.beans;

public class CustomerBean {
	
	int custoNo;
	String nickname, email, password;
	
	public CustomerBean() {
		// TODO Auto-generated constructor stub
	}

	public CustomerBean(int custoNo, String nickname, String email, String password) {
		super();
		this.custoNo = custoNo;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}

	public int getCustoNo() {
		return custoNo;
	}

	public void setCustoNo(int custoNo) {
		this.custoNo = custoNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
