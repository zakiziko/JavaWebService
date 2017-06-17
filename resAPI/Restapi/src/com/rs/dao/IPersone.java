package com.rs.dao;

import java.util.List;
import com.rs.model.*;
public interface IPersone {
	
public void AddPerson(Person p);
	
	public Person FindPersonById(int idp);
	public List<Person> AllPerson();
	public void DeletPerson(int idp);

}
