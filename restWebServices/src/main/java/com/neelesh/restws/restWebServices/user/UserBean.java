package com.neelesh.restws.restWebServices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserBean {

	private Integer id;
	
	@Size(min = 2,message = "Size cant le lesser the 2")
	private String name;
	
	@Past
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	public UserBean(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	
}
