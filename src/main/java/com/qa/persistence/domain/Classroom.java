package com.qa.persistence.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "Classroom")
public class Classroom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long classroomID;
	
	@Column(length = 30)
	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private List<Trainee> trainees;

	public Classroom(String trainer) {
		super();
		this.trainer = trainer;
	}
	
	public Classroom() {};
	
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
		
	 
   
	
	
}
