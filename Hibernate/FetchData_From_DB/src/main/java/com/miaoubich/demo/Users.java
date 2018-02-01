package com.miaoubich.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;


@Entity//(name="New_USER") // the entity name will be used to create table with name="New_USER" instead of class name="Users".
@Table(name="user_Test")//use this to create a table called "USER_INFO"
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int Uid;
	
	@Column(name="Firstname", nullable=false)//to change the Ufname to Firstname
	private String Ufname;
	
	//@Transient //will skip the following column Ulname
	@Column(name="Lastname")
	private String Ulname;
	
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getUfname() {
		return Ufname;
	}
	public void setUfname(String ufname) {
		Ufname = ufname;
	}
	public String getUlname() {
		return Ulname;
	}
	public void setUlname(String ulname) {
		Ulname = ulname;
	}
	@Override
	public String toString() {
		return "Users [Uid=" + Uid + ", Ufname=" + Ufname + ", Ulname=" + Ulname + "]";
	}
	
	
	
}
