package com.soyaa.spring.ex.lifecycle.model;

public class Person {

	private String name;
	private int age;
	
	// 빈공간에 오른쪽 마우스 클릭- Source - generate getter And setter 하고 내가 만들고 싶은 거 클릭하면 알아서 만들어줌
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
