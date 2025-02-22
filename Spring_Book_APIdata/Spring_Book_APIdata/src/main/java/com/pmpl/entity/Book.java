package com.pmpl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Book {
	@Id
	private int id;
	private String title;
	private String author;
	private String publisher;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Book() {
		super();
		
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
	public Book(int id, String title, String author, String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	

}
