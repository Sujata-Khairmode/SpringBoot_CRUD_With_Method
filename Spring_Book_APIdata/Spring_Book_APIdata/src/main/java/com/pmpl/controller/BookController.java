package com.pmpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmpl.entity.Book;
import com.pmpl.service.BookService;
@RestController
public class BookController {
	@Autowired
	BookService service;
	@PostMapping("/save")
	public String insertData(@RequestBody Book b) {
		String msg=service.insertData(b);
		return msg;
		
	}
	
	@DeleteMapping("/deletedata/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;
	}
	@GetMapping("getone/{id}")
	public String getOneRecord(@PathVariable int id) {
		String msg=service.getOneRecord(id);
		return msg;
	}
	
	@PutMapping("/updateData/{id}")
	public String updateData(@RequestBody Book b, @PathVariable int id) {
		String msg= service.updateData(b, id);
		return msg;
	}
	
	@GetMapping("/getAllData")
	public List<Book> getAllData() {
		List<Book>list= service.getAllData();
		return list;
	}

}
