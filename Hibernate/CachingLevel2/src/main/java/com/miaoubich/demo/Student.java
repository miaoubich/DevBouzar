package com.miaoubich.demo;



import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Student_table")
@Cacheable //we have to specify the class to be cached
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) //specify cache strategy
public class Student {

	@Id
	private int sid;
	private String sname;
	private String color;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", color=" + color + "]";
	}
	
	
}
