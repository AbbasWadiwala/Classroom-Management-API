package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {
	String findAllClassroom();

	String findAClassroom(Integer classroomIDOfClassroomToBeFound);

	String updateAClassroom(Classroom classroomWithNewUpdatedDetails, Integer classroomIDOfClassroomToUpdated);

	String createClassroom(Classroom classroomToBeCreated);

	String delete(Integer classroomIDOfClassroomToBeDeleted);
}
