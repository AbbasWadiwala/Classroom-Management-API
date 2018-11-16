package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {
	String findAllClassroom();

	String findAClassroom(Long classroomIDOfClassroomToBeFound);

	String updateAClassroom(Classroom classroomWithNewUpdatedDetails, Long classroomIDOfClassroomToUpdated);

	String createClassroom(Classroom classroomToBeCreated);

	String delete(Long classroomIDOfClassroomToBeDeleted);
}
