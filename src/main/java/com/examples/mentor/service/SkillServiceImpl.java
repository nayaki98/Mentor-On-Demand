package com.examples.mentor.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.mentor.dao.SkillDao;
import com.examples.mentor.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillDao skilldao;
	
	public void insertSkill(@Valid Skill skill) {
		skilldao.save(skill);
		
	}

}
