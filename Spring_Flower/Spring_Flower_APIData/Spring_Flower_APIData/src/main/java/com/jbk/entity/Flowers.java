package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Flowers {
	@Id
	private int id;
	private String name;
	private String color;
	private String season;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Flowers() {
		super();
		
	}
	public Flowers(int id, String name, String color, String season) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.season = season;
	}
	@Override
	public String toString() {
		return "Flowers [id=" + id + ", name=" + name + ", color=" + color + ", season=" + season + "]";
	}
	
	
	

}
