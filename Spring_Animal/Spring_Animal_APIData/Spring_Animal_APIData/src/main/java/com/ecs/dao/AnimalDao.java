package com.ecs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecs.entity.Animal;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class AnimalDao {
	@Autowired
	SessionFactory sf;
	public String insertData(Animal a) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.persist(a);
		tr.commit();
		ss.close();
		return "Data is inserted...";
		
	}
	
	
	public String deleteData(int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		Animal a1=ss.get(Animal.class, id);
		ss.remove(a1);
		tr.commit();
		ss.close();
		return "Delete is successfully";
		
	}
    
	public String getOneRecord(int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Animal a2=ss.get(Animal.class, id);
		
		tr.commit();
		ss.close();
		return "one record"+ a2.toString();
		
	}
	
	public String updateData(Animal a ,int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Animal a1=ss.get(Animal.class, id);
		a1.setName(a.getName());
		a1.setColor(a.getColor());
		a1.setType(a.getType());
		ss.merge(a1);
		tr.commit();
		ss.close();
		return "data is updated....!";
		
	}
	
	public List<Animal> getAllRec() {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		HibernateCriteriaBuilder hcb=ss.getCriteriaBuilder();
		CriteriaQuery<Object>cq= hcb.createQuery();
		Root<Animal>root= cq.from(Animal.class);
		cq.select(root);
		Query query=ss.createQuery(cq);
		List<Animal>list=query.getResultList();
		return list;
		
	}

	
		
		
		
		
	
	
	
}
