package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Classroom")
@Table(name = "classroom")
public class Classroom {
	
	@Id
	@GeneratedValue
	private Long classroomID;
	
	@Column(length = 30)
	private String trainer;
	
	@OneToMany(
		mappedBy = "classroom",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<Trainee> trainees = new ArrayList<Trainee>();

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
	
	
	public void addTrainee(Trainee traineeToBeAdded) {
		trainees.add(traineeToBeAdded);
		traineeToBeAdded.setClassroom(this);
    }
 
    public void removeTrainee(Trainee traineeToBeRemoved) {
    	trainees.remove(traineeToBeRemoved);
        traineeToBeRemoved.setClassroom(null);
    }
	
	
}
