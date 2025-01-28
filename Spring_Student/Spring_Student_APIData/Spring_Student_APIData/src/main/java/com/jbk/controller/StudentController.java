package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
    @PostMapping("/save")
	public String insertData(@RequestBody Student s) {
		String msg=service.insertData(s);
		return msg;
	}
    @DeleteMapping("/deletedata/{id}")
    public String deleteData(@PathVariable int id) {
    	String msg=service.deleteData(id);
    	return msg;
    }
    
    @GetMapping("/getone/{id}")
    public String getOneRecord(@PathVariable int id) {
    	String msg=service.getOneRecord(id);
    	return msg;
    }
    
    @PutMapping("/updateData/{id}")
    public String updatedata(@RequestBody Student s,@PathVariable int id) {
    	String msg=service.updatedata(s, id);
    	return msg;
    }
    @GetMapping("/getAllData")
    public List<Student> getAllData() {
    	List<Student> list=service.getAllData();
    	return list;
    }
    
}
