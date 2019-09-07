package com.examples.mentor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.examples.mentor.model.Skill;
import com.examples.mentor.service.SkillService;


@Controller
public class SkillControllerImpl implements SkillController {
	
	@Autowired
	private SkillService skillservice;
	
	@RequestMapping(path="/addskill")
	public String insertSkill(Model model) throws Exception {
		Skill skill=new Skill();
		model.addAttribute("skill", skill);
		return "insertSkill";
	}
	@RequestMapping(value = "/skillInsert", method = RequestMethod.GET)
	public String submit(@ModelAttribute("skill") @Valid Skill skill, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "insertSkill";
		}

		skillservice.insertSkill(skill);
		
		return "redirect:/homePage";
	}
}
