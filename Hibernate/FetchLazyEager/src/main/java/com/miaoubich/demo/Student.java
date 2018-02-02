package com.miaoubich.demo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	private String name;
	private int marks;
	
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	private Collection<Laptop> laptop = new ArrayList<Laptop>();
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Collection<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(Collection<Laptop> laptop) {
		this.laptop = laptop;
	}
}
