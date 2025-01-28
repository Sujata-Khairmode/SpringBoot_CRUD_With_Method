package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Flowers;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class FlowersDao {
	@Autowired
	SessionFactory sf;
	
	public String insertData(Flowers f) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.persist(f);
		tr.commit();
		ss.close();
		return "Data is Inserted...";
		
	}
	
	public String deleteData(int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Flowers f1=ss.get(Flowers.class, id);
		ss.remove(f1);
		tr.commit();ss.
		close();
		return "data is deleted...!";
	}
 
	public String getOneRecord(int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Flowers f2=ss.get(Flowers.class, id);
		tr.commit();
		ss.close();
		return "One Record is Fetched....!"+f2.toString();
	}
	
	public String updateData(Flowers f,int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Flowers f1=ss.get(Flowers.class, id);
		f1.setColor(f.getColor());
		f1.setName(f.getName());
		f1.setSeason(f.getSeason());
		ss.merge(f1);
		tr.commit();
		ss.close();
		return "flowers data is updated...!";
	}
	
	public List<Flowers> getAllRec() {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		HibernateCriteriaBuilder hcb=ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq=hcb.createQuery();
		Root<Flowers>root=cq.from(Flowers.class);
		cq.select(root);
		Query query=ss.createQuery(cq);
		List list=query.getResultList();
		return list;
	}
}
