package com.examples.mentor.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examples.mentor.model.Status;
import com.examples.mentor.model.Users;
public interface StatusDao extends JpaRepository<Status, Integer>{

	List<Status> findByuserId(int userId);

	
	
	@Query("select um from Status um where mentorId= :mentorId ")
	List<Status> findBymentorId(@Param("mentorId")int mentorId);



	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update Status s SET s.status = 'accepted' where s.userId = :userId and s.mentorId=:mentorId")
	void acceptRequest(@Param("userId") int userId,@Param("mentorId") int mentorId);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update Status s SET s.status = 'rejected' where s.userId = :userId and s.mentorId=:mentorId")
	void rejectRequest(@Param("userId") int userId,@Param("mentorId") int mentorId);


}



