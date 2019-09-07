package com.examples.mentor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.mentor.dao.StatusDao;
import com.examples.mentor.model.Status;
import com.examples.mentor.model.Users;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	StatusDao statusdao;
	
	public void save(Status status) {
	
		statusdao.save(status);
	}
	
	public List<Status> findByUserId(int userId) {
		
		return statusdao.findByuserId(userId);
	}
	public List<Status> findBymentorId(int mentorId) {
		
		return statusdao.findBymentorId(mentorId);
	}


	public void acceptRequest(int userId, int mentorId) {
		statusdao.acceptRequest(userId,mentorId);
		
	}


	public void rejectRequest(int userId, int mentorId) {
		
		statusdao.rejectRequest(userId,mentorId);
	}

}
