package com.qa.interoprability.rest;



import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomBusinessService;



@Path("/classroom")
public class ClassroomManagementAPIEndPoint {
	
	@Inject
	private ClassroomBusinessService service;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String findAllClassroom() {
		return service.findAllClassroom();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String findAClassroom(@PathParam("id") Long classroomIDOfClassroomToBeFound) {
		return service.findAClassroom(classroomIDOfClassroomToBeFound);
	}
	
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String classroomToBeCreated) {
		return service.createClassroom(classroomToBeCreated);
	}
	
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json"})
	public String updateClassroom(@PathParam("id") Long classroomIDOfClassroomToUpdated, String classroomWithNewUpdatedDetails) {
		return service.updateAClassroom(classroomWithNewUpdatedDetails, classroomIDOfClassroomToUpdated);
	}
	
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String delete(@PathParam("id") Long classroomIDOfClassroomToBeDeleted) {
		return service.delete(classroomIDOfClassroomToBeDeleted);
	}
	
	
}