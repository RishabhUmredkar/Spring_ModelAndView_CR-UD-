package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MVCrud")
public class Student {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roll;
	private String name;
	private String marks;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int roll) {
		super();
		this.roll = roll;
	}

	public Student(String name, String marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public Student(int roll, String name, String marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	
}
