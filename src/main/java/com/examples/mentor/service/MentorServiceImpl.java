package com.examples.mentor.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.mentor.dao.MentorDao;
import com.examples.mentor.model.Mentor;

@Service
public class MentorServiceImpl implements MentorService{
	@Autowired
	MentorDao mentordao;


	public void insertMentor( Mentor mentor) {
		mentordao.save(mentor);
		
	}


	
	public Mentor findByemail(String email) {
		
		return mentordao.findByemail(email);
	}



	public List<Mentor> getmentorList() {
		
		return mentordao.findAll();
	}



	
	public List<Mentor> findByTechnology(String technology) {
		
		return mentordao.findBytechnology(technology);
	}



	
	public List<Mentor> findByTime(String fromTime) {
		
		return mentordao.findByfromTime(fromTime);
	}



	
	public void blockById(int mentorId) {
		mentordao.blockBymentorId(mentorId);
		
	}



	
	public void unblockById(int mentorId) {
		mentordao.unblockBymentorId(mentorId);
		
	}

}
