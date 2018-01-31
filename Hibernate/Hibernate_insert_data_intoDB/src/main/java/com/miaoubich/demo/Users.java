package com.miaoubich.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity//(name="New_USER") // the entity name will be used to create table with name="New_USER" instead of class name="Users".
@Table(name="USER_INFO")//use this to create a table called "USER_INFO"
public class Users {

	@Id
	private int Uid;
	@Column(name="Firstname")//to change the Ufname to Firstname
	private String Ufname;
	//@Transient //will skip the following column Ulname
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
	
}
