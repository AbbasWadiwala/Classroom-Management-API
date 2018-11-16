package com.qa.business.service;


public interface ClassroomBusinessService {
	String findAllClassroom();

	String findAClassroom(Long classroomIDOfClassroomToBeFound);

	String updateAClassroom(String classroomWithNewUpdatedDetails, Long classroomIDOfClassroomToUpdated);

	String createClassroom(String classroomToBeCreated);

	String delete(Long classroomIDOfClassroomToBeDeleted);
}
