package com.javalec.function;

import java.io.FileInputStream;

public class ReviewBean {

	//Field
	int reviewNo; // db연결 / 데이터베이스에 있는 테이블로 연결됨 
	//String reviewImage;
	String reviewGrade;
	String reviewContents;
	String reviewMenu;
	String reviewPrice;
	String reviewInsertTime;
	int customer_custoNo;
	int store_storeNo;
	// 리뷰 이미지 파일 필드
	FileInputStream reviewImagefile;
	
	
	//Constructor
	public ReviewBean() {
		// TODO Auto-generated constructor stub
	}


	public ReviewBean(int reviewNo, String reviewGrade, String reviewContents, String reviewMenu, String reviewPrice,
			String reviewInsertTime, int customer_custoNo, int store_storeNo, FileInputStream reviewImagefile) {
		super();
		this.reviewNo = reviewNo;
		this.reviewGrade = reviewGrade;
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.reviewInsertTime = reviewInsertTime;
		this.customer_custoNo = customer_custoNo;
		this.store_storeNo = store_storeNo;
		this.reviewImagefile = reviewImagefile;
	}


	//Method
	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getReviewGrade() {
		return reviewGrade;
	}


	public void setReviewGrade(String reviewGrade) {
		this.reviewGrade = reviewGrade;
	}


	public String getReviewContents() {
		return reviewContents;
	}


	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}


	public String getReviewMenu() {
		return reviewMenu;
	}


	public void setReviewMenu(String reviewMenu) {
		this.reviewMenu = reviewMenu;
	}


	public String getReviewPrice() {
		return reviewPrice;
	}


	public void setReviewPrice(String reviewPrice) {
		this.reviewPrice = reviewPrice;
	}


	public String getReviewInsertTime() {
		return reviewInsertTime;
	}


	public void setReviewInsertTime(String reviewInsertTime) {
		this.reviewInsertTime = reviewInsertTime;
	}


	public int getCustomer_custoNo() {
		return customer_custoNo;
	}


	public void setCustomer_custoNo(int customer_custoNo) {
		this.customer_custoNo = customer_custoNo;
	}


	public int getStore_storeNo() {
		return store_storeNo;
	}


	public void setStore_storeNo(int store_storeNo) {
		this.store_storeNo = store_storeNo;
	}


	public FileInputStream getReviewImagefile() {
		return reviewImagefile;
	}


	public void setReviewImagefile(FileInputStream reviewImagefile) {
		this.reviewImagefile = reviewImagefile;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//<-----
