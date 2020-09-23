package com.matzip.beans;

import javax.swing.ImageIcon;

public class StoreBean {
	
	int storeNo;
	static String storeName;
	String storePhone;
	String storeOTime;
	String storeAddress;
	String foodCategory;
	String editor;
	String dayOff;
	
	ImageIcon imgIcon;
	
	public StoreBean() {
		// TODO Auto-generated constructor stub
	}

	public StoreBean(String storeName, String storePhone, String storeOTime, String storeAddress, String foodCategory) {
		super();
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeOTime = storeOTime;
		this.storeAddress = storeAddress;
		this.foodCategory = foodCategory;
	}

	public StoreBean(String storeName, String storePhone, String storeOTime, String storeAddress, String foodCategory, ImageIcon imgIcon) {
		super();
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeOTime = storeOTime;
		this.storeAddress = storeAddress;
		this.foodCategory = foodCategory;
		this.imgIcon = imgIcon;
	}

	public StoreBean(String storeName, String storePhone, String storeOTime, String storeAddress, String foodCategory,
			String editor, String dayOff, ImageIcon imgIcon) {
		super();
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeOTime = storeOTime;
		this.storeAddress = storeAddress;
		this.foodCategory = foodCategory;
		this.editor = editor;
		this.dayOff = dayOff;
		this.imgIcon = imgIcon;
	}

	public StoreBean(int storeNo, String storeName, String storePhone, String storeOTime, String storeAddress,
			String foodCategory, String editor, String dayOff, ImageIcon imgIcon) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeOTime = storeOTime;
		this.storeAddress = storeAddress;
		this.foodCategory = foodCategory;
		this.editor = editor;
		this.dayOff = dayOff;
		this.imgIcon = imgIcon;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public static String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreOTime() {
		return storeOTime;
	}

	public void setStoreOTime(String storeOTime) {
		this.storeOTime = storeOTime;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getDayOff() {
		return dayOff;
	}

	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}

	public ImageIcon getImgIcon() {
		return imgIcon;
	}

	public void setImgIcon(ImageIcon imgIcon) {
		this.imgIcon = imgIcon;
	}

}
