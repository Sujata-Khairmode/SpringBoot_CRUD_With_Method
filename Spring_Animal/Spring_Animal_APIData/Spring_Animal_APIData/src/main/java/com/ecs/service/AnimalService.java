package com.ecs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecs.dao.AnimalDao;
import com.ecs.entity.Animal;
@Service
public class AnimalService {
	 @Autowired
	AnimalDao dao;
	public String insertData(Animal a) {
		String msg=dao.insertData(a);
		return msg;
		
	}
	
	public String deleteData(int id) {
		String msg=dao.deleteData(id);
		return msg;
		
	}
	
	public String getOneRecord(int id) {
		String msg=dao.getOneRecord(id);
		return msg;
		
	}
	
	public String updateData(Animal a, int id) {
		String msg=dao.updateData(a, id);
		return msg;
	}
	
	public List<Animal> getAllRec() {
		List<Animal> list=dao.getAllRec();
		return list;
	}

}
