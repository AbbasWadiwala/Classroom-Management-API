package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;

@RequestScoped
@Default
@Transactional(SUPPORTS)
public class ClassroomPersistenceDBRepositoryImpl implements ClassroomRepository{
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Override
	public String findAllClassroom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAClassroom(Integer classroomIDOfClassroomToBeFound) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAClassroom(Classroom classroomWithNewUpdatedDetails, Integer classroomIDOfClassroomToUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(Classroom classroomToBeCreated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Integer classroomIDOfClassroomToBeDeleted) {
		// TODO Auto-generated method stub
		return null;
	}

}
