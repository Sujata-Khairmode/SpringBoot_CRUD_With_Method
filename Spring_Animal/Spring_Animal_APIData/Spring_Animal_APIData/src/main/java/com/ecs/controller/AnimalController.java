package com.ecs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecs.entity.Animal;
import com.ecs.service.AnimalService;
@RestController
public class AnimalController {
	@Autowired
  AnimalService service;
	
	@PostMapping("/save")
	public String insertData(@RequestBody Animal a) {
		String msg=service.insertData(a);
		return msg;
		
	}
	@DeleteMapping("/deletedata/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData( id);
		return msg;
		
	}
	@GetMapping("/getone/{id}")
	public String getOneRecord(@PathVariable int id) {
		String msg=service.getOneRecord(id);
			return msg;
			
		
	}
	
	@PutMapping("/update/{id}")
	public String updateData(@RequestBody Animal a, @PathVariable int id) {
		String msg=service.updateData(a, id);
		return msg;
	}
	@GetMapping("/getAllRec")
	public List<Animal> getAllRec() {
	List<Animal>list=service.getAllRec();
	return list;
	}
}
