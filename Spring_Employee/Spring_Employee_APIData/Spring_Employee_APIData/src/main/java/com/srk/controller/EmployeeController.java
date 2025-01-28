package com.srk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srk.entity.Employee;
import com.srk.service.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("/submit")
	public String insertData(@RequestBody Employee e) {
		String msg=service.insertData(e);
		return msg;
	}
	@DeleteMapping("/deteledata/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;
	}
	@GetMapping("/getone/{id}")
	public String getOneRecord(@PathVariable int id) {
		String msg=service.getOneRecord(id);
		return msg;
	}
	@GetMapping("/getAllData")
	public List<Employee> getAllData() {
		List<Employee>list= service.getAllData();
		return list;
	}
	
	@PutMapping("/updateData/{id}")
	public String updateData(@RequestBody Employee e,@PathVariable int id) {
		String msg=service.updateData(e, id);
		return msg;
	}

}
