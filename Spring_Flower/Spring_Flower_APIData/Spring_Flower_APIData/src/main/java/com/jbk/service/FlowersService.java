package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.FlowersDao;
import com.jbk.entity.Flowers;
@Service
public class FlowersService {
	@Autowired
    FlowersDao dao;
    
    public String insertData(Flowers f) {
    	String msg=dao.insertData(f);
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
    
    public String updateData(Flowers f,int id) {
    	String msg=dao.updateData(f, id);
    	return msg;
    }
    
    public List<Flowers> getAllRec() {
    	List<Flowers> msg=dao.getAllRec();
    	return msg;
    }
}
