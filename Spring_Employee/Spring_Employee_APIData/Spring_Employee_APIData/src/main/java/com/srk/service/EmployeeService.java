package com.srk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srk.dao.EmployeeDao;
import com.srk.entity.Employee;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	
	public String insertData(Employee e) {
		String msg=dao.insertData(e);
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
	
	public List<Employee> getAllData() {
		List<Employee> list=dao.getAllRecord();
		return list;
	}
	
	public String updateData(Employee e,int id) {
		 String msg=dao.updateData(e, id);
		 return msg;
		
	}
}
