package com.examples.mentor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examples.mentor.model.Mentor;



public interface MentorDao  extends JpaRepository<Mentor, Integer>{

	Mentor findByemail(String email);

	List<Mentor> findBytechnology(String technology);

	List<Mentor> findByfromTime(String fromTime);

	Mentor findBymentorId(int id);
	
	
	@Transactional
    @Modifying
    @Query("update Mentor m set m.active=true where m.mentorId=:mentorId")
	public void blockBymentorId(@Param("mentorId")int mentorId);
    @Transactional
    @Modifying
    @Query("update Mentor m set m.active=false where m.mentorId=:mentorId")
    public void unblockBymentorId(@Param("mentorId")int mentorId);


}
