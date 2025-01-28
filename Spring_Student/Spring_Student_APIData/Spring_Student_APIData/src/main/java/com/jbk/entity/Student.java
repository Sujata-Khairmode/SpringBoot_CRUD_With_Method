package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
 private int id;
 private String name;
 private String city;
 private int age;
 private long mobileNo;
public int getId() {
	return id;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
public Student() {
	super();
	
}
public Student(int id, String name, String city, int age, long mobileNo) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.age = age;
	this.mobileNo = mobileNo;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + ", mobileNo=" + mobileNo + "]";
}
 
}
