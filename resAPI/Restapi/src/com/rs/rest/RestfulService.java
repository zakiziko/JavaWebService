package com.rs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.yasson.internal.serializer.JsonObjectSerializer;

import com.rs.dao.PersonManager;
import com.rs.model.Person;


@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestfulService extends Application{
	//http://localhost:8080/Restapi/resources/MyRestService
	@GET
	@Path("/sayHello")
	public String SayHello(){
		return "Hello Word!!";
	}
	
	@GET
	@Path("find/{PersonId}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("PersonId") String id){
		Person test = new Person();
		PersonManager m =new PersonManager();	
		Person p = m.FindPersonById(Integer.parseInt(id));
		test.setAge(p.getAge());
		test.setLastname(p.getLastname());
		test.setName(p.getName());
		test.setId(p.getId());
		return test;
		
		 
	}
	
	@POST
	//@javax.ws.rs.Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addPerson")
	public void addPerson(Person person){
		PersonManager m = new PersonManager();
		m.AddPerson(person);
	}
	
	@GET
	@Path("/getAll")
	@javax.ws.rs.Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Person> getall(){
		PersonManager m = new PersonManager();
		List<Person> list = (List<Person>) m.AllPerson();
		return list;
	}
	
	@GET
	@Path("/findall")
	@javax.ws.rs.Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response findall(){
		PersonManager m = new PersonManager();
		List<Person> list = (List<Person>) m.AllPerson();
		return Response
				.ok()
				.entity(list)
			   .build();
	}
	
	@DELETE
	@Path("delet/{PersonId}")
	//@javax.ws.rs.Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public Response deletPerson(@PathParam("PersonId") int id){
		PersonManager m = new PersonManager();
		m.DeletPerson(id);
		//String s ="DELETED";
		return Response
				.ok()
			    .build();
		
	}
	
	
}
