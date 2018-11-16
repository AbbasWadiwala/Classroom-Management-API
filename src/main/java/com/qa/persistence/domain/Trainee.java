package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Trainee")
@Table(name = "trainee")
public class Trainee {
	
	@Id
	@GeneratedValue
	private Long traineeID;
	
	@Column
	private String trainieeName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

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

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Trainee)) return false;
		return traineeID != null && traineeID.equals(((Trainee) o).traineeID);
	}
	
	@Override
    public int hashCode() {
        return 31;
    }
	
}
