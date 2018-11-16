package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Trainee")
public class Trainee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long traineeID;
	
	@Column
	private String trainieeName;
	
	public Trainee(String trainieeName) {
		super();
		this.trainieeName = trainieeName;
	}
	
	public Trainee() {};
	
	
	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTrainieeName() {
		return trainieeName;
	}

	public void setTrainieeName(String trainieeName) {
		this.trainieeName = trainieeName;
	}

	
	
}
