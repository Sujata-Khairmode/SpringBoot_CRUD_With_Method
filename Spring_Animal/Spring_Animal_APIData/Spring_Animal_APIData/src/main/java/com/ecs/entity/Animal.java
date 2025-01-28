package com.ecs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {
	@Id
	private int id;
	private String name;
	private String type;
	private String color;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Animal() {
		super();
		
	}
	public Animal(int id, String name, String type, String color) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", type=" + type + ", color=" + color + "]";
	}
	
	
	

}
