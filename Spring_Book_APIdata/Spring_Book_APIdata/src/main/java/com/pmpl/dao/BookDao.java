package com.pmpl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmpl.entity.Book;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
@Repository
public class BookDao {
	@Autowired
	SessionFactory sf;
	
	public String insertData(Book b) {
		
		
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.persist(b);
		tr.commit();
		ss.close();
		return "Data is inserted.....";
		
		
	}
	
	public String deletedata(int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Book b1=ss.get(Book.class, id);
		ss.remove(b1);
		tr.commit();
		ss.close();
		return "Data is deleted....!";
	}
	
	public String getOneRecord(int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Book b2=ss.get(Book.class, id);
		tr.commit();
		ss.close();
		return "Get one record"+ b2.toString();
		
	}
	
	public String updateData(Book b, int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Book b1= ss.get(Book.class, id);
		b1.setAuthor(b.getAuthor());
		b1.setPublisher(b.getPublisher());
		b1.setTitle(b.getTitle());
		tr.commit();
		ss.close();
		return "data is updated successfully....!";
		
		
	}
	
	public List<Book> getAllData() {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		HibernateCriteriaBuilder hcb= ss.getCriteriaBuilder();
		 CriteriaQuery<Object>cq=hcb.createQuery();
		 Root<Book>root=cq.from(Book.class);
		 cq.select(root);
		 Query query =ss.createQuery(cq);
		List<Book>list= query.getResultList();
		return list;
	}
	
}
