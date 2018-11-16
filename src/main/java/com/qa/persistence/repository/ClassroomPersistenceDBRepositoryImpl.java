package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
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
		List<Trainee> trainees = manager.createQuery(
			    "select t " +
			    "from Trainee t " +
			    "where t.classroom.classroom_id = :classroomId", Trainee.class)
			.setParameter( "classroomId", classroomIDOfClassroomToBeFound )
			.getResultList();
		return JSONUtil.getJSONForObject(trainees);
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAClassroom(Classroom classroomWithNewUpdatedDetails, Long classroomIDOfClassroomToUpdated) {
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
	public String delete(Long classroomIDOfClassroomToBeDeleted) {
		// TODO Auto-generated method stub
		return null;
	}

}
