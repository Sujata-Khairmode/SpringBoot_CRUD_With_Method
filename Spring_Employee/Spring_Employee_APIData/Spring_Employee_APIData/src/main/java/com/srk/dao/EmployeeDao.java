package com.srk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srk.entity.Employee;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory sf;

	public String insertData(Employee e) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(e);
		tr.commit();
		ss.close();
		return "Data is inserted...";

	}

	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e1 = ss.get(Employee.class, id);
		ss.remove(e1);
		tr.commit();
		ss.close();
		return "Data deteted....!";
	}

	public String getOneRecord(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e2 = ss.get(Employee.class, id);
		tr.commit();
		ss.close();
		return "One data is fetched...!" + e2.toString();
	}

	public List<Employee> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		Query query = ss.createQuery(cq);
		List<Employee> list = query.getResultList();
		return list;

	}

	public String updateData(Employee e, int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e1 = ss.get(Employee.class, id);
		e1.setAge(e.getAge());
		e1.setCity(e.getCity());
		e1.setDept(e.getDept());
		e1.setMobileNo(e.getMobileNo());
		e1.setName(e.getName());
		e1.setSalary(e.getSalary());
		ss.merge(e1);
		tr.commit();
		ss.close();
		return "data is updated successfully...!";
		
	}

}
