package com.soyaa.spring.ex.database.model;

import java.util.Date;

public class UsedGoods {
	
	private int id;
	private int sellorId;
	private String title;
	private int price;
	private String description;
	private String picture;
	private Date createdAt;   // 시간이니까 Date 로 저장, java.util.Date import!!
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellorId() {
		return sellorId;
	}
	public void setSellorId(int sellorId) {
		this.sellorId = sellorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
