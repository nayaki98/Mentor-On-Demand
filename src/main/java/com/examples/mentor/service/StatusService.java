package com.examples.mentor.service;

import java.util.List;

import com.examples.mentor.model.Status;
import com.examples.mentor.model.Users;

public interface StatusService {

	void save(Status status);

	List<Status> findByUserId(int userId);

	List<Status> findBymentorId(int mentorId);

	void acceptRequest(int userId, int mentorId);

	void rejectRequest(int userId, int mentorId);

}
