package com.javalec.function;

public class AddStoreBean {
	int storeno;   // 매장번호 키값 
	String storeName; // 매장명 	
	String storePhone; // 매장 전화번호 
	String storeAddress; // 매장 주소 
	String storeOTime; // 매장 영업시간 
	String foodCategory;	// 음식 종류 
	String storeImage; // 매장 이미지
	
	private void bean() {
		// TODO Auto-generated method stub

	}

	public AddStoreBean(int storeno, String storeName, String storePhon, String storeAddress, String storeoTime, String foodCategory,
			String storeImage, String storePhone) {
		super();
		this.storeno = storeno;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeOTime = storeoTime;
		this.foodCategory = foodCategory;
		this.storeImage = storeImage;
	}

	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno=storeno;
	}
	public String getName() {
		return storeName;
	}
	public void setName(String storeName) {
		this.storeName= storeName;
	}
	public String getPhone() {
		return storePhone;
	}
	public void setPhone(String storePhon) {
		this.storePhone= storePhon;
	}
	public String getAddress() {
		return storeAddress;
	}
	public void setAddress(String storeAddress){
		this.storeAddress= storeAddress;
	}
	public String getOTime() {
		return storeOTime;
	}
	public void setOTime(String storeOTime){
		this.storeOTime=storeOTime;
	}
	public String getfoodCategory() {
		return foodCategory;
	}
	public void setfoodCategory(String foodCategory){
		this.foodCategory=foodCategory;
	}
	public String getImage() {
		return storeImage;
	}
	public void setImage(String storeImage){
		this.storeImage=storeImage;
	}
	
	
	
	
	
	
	
	
}
	