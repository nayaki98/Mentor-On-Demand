package com.examples.mentor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_mentor_request")
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")	
	private int Id;

	@Column(name="mentorid")	
	private int mentorId;
	
	@Column(name="userid")	
	private int userId;
	
	@Column(name="status")
	private String status;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
