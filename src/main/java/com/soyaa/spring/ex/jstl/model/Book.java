package com.soyaa.spring.ex.jstl.model;

public class Book {

	private String title;
	private String author;
	private String publisher;
	
	// private로 지정되어있기 때문에 바로 쓸 수가 없다 . getter setter 만들어주기
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
