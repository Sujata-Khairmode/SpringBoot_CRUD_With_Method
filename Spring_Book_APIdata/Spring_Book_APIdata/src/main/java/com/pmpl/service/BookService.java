package com.pmpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmpl.dao.BookDao;
import com.pmpl.entity.Book;
@Service
public class BookService {
	@Autowired
	BookDao dao;
	public String insertData(Book b) {
		String msg=dao.insertData(b);
		return msg;
		
	}
	
	public String deleteData(int id) {
		String msg=dao.deletedata(id);
		return msg;
	}
	
	public String getOneRecord(int id) {
		String msg=dao.getOneRecord(id);
		return msg;
	}
	
	public String updateData(Book b,int id) {
		String msg=dao.updateData(b, id);
		return msg;
	}
	
	public List<Book> getAllData() {
	List<Book>list=dao.getAllData();
	return list;
	}

}
