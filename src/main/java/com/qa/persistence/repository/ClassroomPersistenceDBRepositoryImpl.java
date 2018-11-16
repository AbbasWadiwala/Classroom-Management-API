package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;

import com.qa.utils.JSONUtil;

@RequestScoped
@Default
@Transactional(SUPPORTS)
public class ClassroomPersistenceDBRepositoryImpl implements ClassroomRepository{
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Override
	public String findAllClassroom() {
		TypedQuery<Classroom> query = manager.createQuery("SELECT m FROM Classroom m ORDER BY m.classroomID DESC", Classroom.class);
		return JSONUtil.getJSONForObject(query.getResultList());
	}

	@Override
	public String findAClassroom(Long classroomIDOfClassroomToBeFound) {
		return JSONUtil.getJSONForObject(manager.find(Classroom.class, classroomIDOfClassroomToBeFound));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAClassroom(Classroom classroomWithNewUpdatedDetails, Long classroomIDOfClassroomToUpdated) {
		Classroom classroomToBeUpdated = manager.find(Classroom.class, classroomIDOfClassroomToUpdated);
		classroomToBeUpdated.setTrainees(classroomWithNewUpdatedDetails.getTrainees());
		classroomToBeUpdated.setTrainer(classroomWithNewUpdatedDetails.getTrainer());
		manager.merge(classroomToBeUpdated);
		return "Account Updated Successfully";
		//return JSONUtil.getJSONForObject(manager.find(Classroom.class, classroomToBeUpdated.getClassroomID()));
	}

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(Classroom classroomToBeCreated) {
		manager.persist(classroomToBeCreated);		
		if(manager.find(Classroom.class, classroomToBeCreated.getClassroomID()) != null){
			return "Account Created Successfully :- \n" + JSONUtil.getJSONForObject(manager.find(Classroom.class, classroomToBeCreated.getClassroomID()));
		}
		return "Account Was Not Created Successfully";
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Long classroomIDOfClassroomToBeDeleted) {
		Classroom accountToBeDeleted = manager.find(Classroom.class, classroomIDOfClassroomToBeDeleted);
		manager.remove(accountToBeDeleted);
		if(manager.find(Classroom.class, accountToBeDeleted.getClassroomID()) == null){
			return "Account Successfully Deleted";
		}
		return "Failed to Delete";
		
	}

}
