package com.examples.mentor.service;

import javax.validation.Valid;

import com.examples.mentor.model.Skill;

public interface SkillService {

	void insertSkill(@Valid Skill skill);

}
