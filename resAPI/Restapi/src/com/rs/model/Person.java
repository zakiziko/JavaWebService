package com.rs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person{
	private int id;
	private String name;
	private String lastname;
	private int age;
	
	public Person(){
		
	}
	public Person(int id, String name, String lastname, int age) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	}
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@XmlElement
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
