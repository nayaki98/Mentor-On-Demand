package com.examples.mentor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.mentor.model.Mentor;
import com.examples.mentor.model.Users;
import com.examples.mentor.service.MentorService;
import com.examples.mentor.service.UserService;

@Controller
public class AdminControllerImpl implements AdminController{
	
	@Autowired
	private MentorService mentorservice;


	@Autowired
	private UserService userservice;
	
	@RequestMapping(path="/index")
	public String indexPage(Model model) throws Exception {
		
		return "index";
	}
	
	@RequestMapping(path="/adminHomePage")
	public String adminHomePage(Model model) throws Exception {
		
		return "adminHome";
	}
	
	@RequestMapping(path="/logout")
	public String logout(Model model) throws Exception {
		
		return "logout";
	}
	
	@RequestMapping(value = "/blockuser")
    public String blockUser(ModelMap model, @RequestParam("id") int userId,
                  @ModelAttribute("user") Users user) {
           boolean a=user.isActive();
           if(a==false)
           {             
        	   userservice.blockById(userId);
           }
           
           return "redirect:/userListAdmin";
    }
    @RequestMapping(value = "/Unblockuser")
    public String unblockUser(ModelMap model, @RequestParam("id") int userId,
                  @ModelAttribute("user") Users user) {
        
           boolean a=user.isActive();     
          
           a=true;
           if(a==true)
           {                          

        	   userservice.unblockById(userId);
           }
           
           return "redirect:/userListAdmin";
    }
	
	@RequestMapping(value = "/blockmentor")
    public String blockMentor(ModelMap model, @RequestParam("id") int mentorId,
                  @ModelAttribute("mentor") Mentor mentor) {
          
           boolean a=mentor.isActive();
           if(a==false)
           {             
        	   mentorservice.blockById(mentorId);
           }
           
           return "redirect:/mentorListAdmin";
    }
    @RequestMapping(value = "/Unblockmentor")
    public String unblockMentor(ModelMap model, @RequestParam("id") int mentorId,
                  @ModelAttribute("mentor") Mentor mentor) {
        
           boolean a=mentor.isActive();     
          
           a=true;
           if(a==true)
           {                          

        	   mentorservice.unblockById(mentorId);
           }
         
           return "redirect:/mentorListAdmin";
    }

    @RequestMapping(path="/userListAdmin")
	public ModelAndView getuserList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminUser");
		mv.addObject("userList",userservice.getuserList());
		return mv;
	}
    
    @RequestMapping(path="/mentorListAdmin")
	public ModelAndView getmentorList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminMentor");
		mv.addObject("mentorList",mentorservice.getmentorList());
		return mv;
	}
}