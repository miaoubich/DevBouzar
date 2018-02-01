package com.miaoubich.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmbeddableTable")
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int Uid;
	
	private FullName Ufname;
	
	private String Ulname;

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public FullName getUfname() {
		return Ufname;
	}

	public void setUfname(FullName ufname) {
		Ufname = ufname;
	}

	public String getUlname() {
		return Ulname;
	}

	public void setUlname(String ulname) {
		Ulname = ulname;
	}
}
