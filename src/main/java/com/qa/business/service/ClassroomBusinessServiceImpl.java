package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.utils.JSONUtil;

public class ClassroomBusinessServiceImpl implements ClassroomBusinessService{
	
	
	@Inject
	private ClassroomRepository repo;
	
	@Override
	public String findAllClassroom() {
		
		return repo.findAllClassroom();
	}

	@Override
	public String findAClassroom(Long classroomIDOfClassroomToBeFound) {
		
		return repo.findAClassroom(classroomIDOfClassroomToBeFound);
	}

	@Override
	public String updateAClassroom(String classroomWithNewUpdatedDetails, Long classroomIDOfClassroomToUpdated) {
		
		return repo.updateAClassroom(JSONUtil.getObjectForJSON(classroomWithNewUpdatedDetails, Classroom.class), classroomIDOfClassroomToUpdated);
	}

	@Override
	public String createClassroom(String classroomToBeCreated) {
		
		return repo.createClassroom(JSONUtil.getObjectForJSON(classroomToBeCreated, Classroom.class));
	}

	@Override
	public String delete(Long classroomIDOfClassroomToBeDeleted) {
		
		return repo.delete(classroomIDOfClassroomToBeDeleted);
	}

}
