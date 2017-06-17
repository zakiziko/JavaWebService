package com.rs.dao;

import java.util.List;

import org.hibernate.Session;

import com.rs.model.*;
import com.rs.util.*;

public class PersonManager implements IPersone {

	@Override
	public void AddPerson(Person p) {
		Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
		ses.beginTransaction();
		ses.save(p);
		ses.getTransaction().commit();

	}

	@Override
	public Person FindPersonById(int idp) {
		Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
		ses.beginTransaction();
		Person p=(Person) ses.load(Person.class, idp);
		return p;
	}

	@Override
	public List<Person> AllPerson() {
		Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
		ses.beginTransaction();
	    return ses.createQuery("from Person").list();
	}

	@Override
	public void DeletPerson(int idp) {
		Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
		ses.beginTransaction();
		Person p=(Person) ses.load(Person.class, idp);
		ses.delete(p);
		ses.getTransaction().commit();

	}

}
