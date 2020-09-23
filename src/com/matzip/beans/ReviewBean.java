package com.matzip.beans;

import javax.swing.ImageIcon;

public class ReviewBean {
	
	int reviewNo, custoNo, storeNo;
	String reviewGrade, reviewContents, reviewMenu, reviewPrice;
	ImageIcon reviewImage;
	
	String nickName;
	
	public ReviewBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ReviewBean(int reviewNo, String reviewGrade, String reviewContents, String nickName) {
		super();
		this.reviewNo = reviewNo;
		this.reviewGrade = reviewGrade;
		this.reviewContents = reviewContents;
		this.nickName = nickName;
	}

	public ReviewBean(String nickName, String reviewMenu, String reviewPrice, String reviewContents) {
		super();
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.nickName = nickName;
	}

	public ReviewBean(String nickName, String reviewMenu, String reviewPrice, String reviewContents, String reviewGrade) {
		super();
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.nickName = nickName;
		this.reviewGrade = reviewGrade;
	}

	public ReviewBean(String nickName, String reviewMenu, String reviewPrice, String reviewContents, String reviewGrade, ImageIcon reviewImage) {
		super();
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
		this.nickName = nickName;
		this.reviewGrade = reviewGrade;
		this.reviewImage = reviewImage;
	}

	public ReviewBean(int reviewNo, int custoNo, int storeNo, String reviewGrade, String reviewContents,
			String reviewMenu, String reviewPrice) {
		super();
		this.reviewNo = reviewNo;
		this.custoNo = custoNo;
		this.storeNo = storeNo;
		this.reviewGrade = reviewGrade;
		this.reviewContents = reviewContents;
		this.reviewMenu = reviewMenu;
		this.reviewPrice = reviewPrice;
	}

	public ImageIcon getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(ImageIcon reviewImage) {
		this.reviewImage = reviewImage;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getCustoNo() {
		return custoNo;
	}

	public void setCustoNo(int custoNo) {
		this.custoNo = custoNo;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(String reviewGrade) {
		this.reviewGrade = reviewGrade;
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
	

}
