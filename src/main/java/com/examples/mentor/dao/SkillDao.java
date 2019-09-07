package com.examples.mentor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.mentor.model.Skill;


public interface SkillDao extends JpaRepository<Skill, Integer>{

}
