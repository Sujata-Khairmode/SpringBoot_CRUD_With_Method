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

import com.jbk.entity.Flowers;
import com.jbk.service.FlowersService;
@RestController
public class FlowersController {
	@Autowired
	FlowersService service;
	@PostMapping("/submit")
	public String insertData(@RequestBody Flowers f) {
		String msg=service.insertData(f);
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
	public String updateData(@RequestBody Flowers f,@PathVariable int id) {
		String msg=service.updateData(f, id);
		return msg;
	}
	
	@GetMapping("/getAllRec")
	public List<Flowers> getAllRec() {
		List<Flowers>list=service.getAllRec();
		return list;
	}
}
