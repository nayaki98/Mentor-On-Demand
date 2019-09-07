package com.examples.mentor.service;

import java.util.List;

import javax.validation.Valid;

import com.examples.mentor.model.Mentor;

public interface MentorService {

	void insertMentor(@Valid Mentor mentor);

	Mentor findByemail(String email);

	public List<Mentor> getmentorList();

	public List<Mentor> findByTechnology(String technology);

	public List<Mentor> findByTime(String fromTime);

	void blockById(int mentorId);

	void unblockById(int mentorId);

	

}
