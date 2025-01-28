package com.jbk.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDao;
import com.jbk.entity.Student;
@Service
public class StudentService {
	
	@Autowired
	StudentDao dao;
	
	public String insertData(Student s) {
		String msg=dao.insertData(s);
		if(Objects.isNull(msg)) {
			msg = "data is not inserted.....";
		}
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
	
	public String updatedata(Student s,int id) {
		String msg=dao.updatedata(s, id);
		return msg;
	}
	public List<Student> getAllData(){
		List<Student>list=dao.getAllData();
		return list;
	}
	

}
