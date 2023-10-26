package com.jspiders.cardekho.entity;

public class Car {
	
	private int id;
	private String name;
	private String brand;
	private int price;
	
	public int getId() {
		return this.id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "Car Id = " + id + ", Name = " + name + " , Brand = "+ brand +" , Price "+price;
	}

}
