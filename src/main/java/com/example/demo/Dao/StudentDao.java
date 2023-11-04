package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.demo.model.Student;

public class StudentDao {
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public boolean saveStd(Student s)
	{
		template.save(s);
		return true;
	}
	public List<Student> getAllStd(){
		List<Student> list = new ArrayList<Student>();
		list = template.loadAll(Student.class);
		return list;
	}
}
