package com.rs.test;

import com.rs.dao.PersonManager;
import com.rs.model.Person;

public class Test {
public static void main(String[] args) {
	Person p = new Person();
	p.setAge(24);
	p.setLastname("el");
	p.setName("zak");
	PersonManager m = new PersonManager();
	m.AddPerson(p);
}
}
