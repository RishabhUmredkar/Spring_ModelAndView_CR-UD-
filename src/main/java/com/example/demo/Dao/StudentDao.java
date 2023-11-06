package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;

public class StudentDao {
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

    public boolean saveStd(Student s) {
        template.save(s);
        return true;
    }

    public List<Student> getAllStd() {
        List<Student> list = new ArrayList<Student>();
        list = template.loadAll(Student.class);
        return list;
    }

    public void deleteStudent(Student student) {
        template.delete(student);
    }

    public Student getStudentByRoll(int roll) {
        return template.get(Student.class, roll);
    }

    public void updateStudent(Student student) {
        template.update(student);
    }
}