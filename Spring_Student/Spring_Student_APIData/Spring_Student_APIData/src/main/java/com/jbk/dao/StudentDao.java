package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class StudentDao {
	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {
		Session session = null;
		Transaction tr = null;
		String msg=null;
		try {
			session = factory.openSession();
			tr=session.beginTransaction();
			session.persist(s);
			tr.commit();
			msg = "Data is inserted...";
		}catch(Exception e) {
			if(tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;

	}

	public String deleteData(int id) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Student s1 = session.get(Student.class, id);
		session.remove(s1);
		tr.commit();
		session.close();
		return "data is deleted...!";
	}

	public String getOneRecord(int id) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Student s2 = session.get(Student.class, id);
		tr.commit();
		session.close();
		return "One Recorde is Fetched...!" + s2.toString();

	}

	public String updatedata(Student s, int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s1 = ss.get(Student.class, id);
		s1.setAge(s.getAge());
		s1.setCity(s.getCity());
		s1.setMobileNo(s.getMobileNo());
		s1.setName(s.getName());
		ss.merge(s1);
		tr.commit();
		ss.close();
		return "student data is successfully updated...!";
	}

	public List<Student> getAllData() {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Student> root = cq.from(Student.class);
		cq.select(root);
		Query query = ss.createQuery(cq);
		List<Student> list = query.getResultList();
		return list;
	}
}
