package com.examples.mentor.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.mentor.dao.MentorDao;
import com.examples.mentor.dao.UserDao;
import com.examples.mentor.model.Login;
import com.examples.mentor.model.Mentor;
import com.examples.mentor.model.Status;
import com.examples.mentor.service.LoginService;
import com.examples.mentor.service.MentorService;
import com.examples.mentor.service.StatusService;




@Controller
public class MentorControllerImpl {
	private String role="mentor";
	@Autowired
	private MentorService mentorservice;
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	MentorDao mentorDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StatusService statusservice;
	
	@Autowired
	LoginControllerImpl logincontroller;
	

	
	@RequestMapping(path="/mentor")
	public String insert(Model model) throws Exception {
		Mentor mentor=new Mentor();
		model.addAttribute("mentor", mentor);
		return "mentorRegistration";
	}
	@RequestMapping(value = "/mentorRegistration", method = RequestMethod.GET)
	public String submit(@ModelAttribute("mentor") @Valid Mentor mentor, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "mentorRegistration";
		}

		mentorservice.insertMentor(mentor);
		loginservice.insertLoginDetails(new Login(mentor.getEmail(),mentor.getPassword(),role));
		return "redirect:/mentorHomePage";
	}

	@RequestMapping(path="/mentorList")
	public ModelAndView getmentorList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("mentorList");
		mv.addObject("mentorList",mentorservice.getmentorList());
		return mv;
	}
	@RequestMapping(path="/searchMentorByTechnology")
	public String searchMentor(Model model) throws Exception {
		Mentor mentor=new Mentor();
		model.addAttribute("mentor", mentor);
		return "searchMentorTechnology";
	}
	
	@RequestMapping(value = "/getMentorsByTechnology", method = RequestMethod.POST)
	public ModelAndView getMentorsByTechnology(Mentor mentor) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchMentorListTechnology");
		mv.addObject("mentorList",mentorservice.findByTechnology(mentor.getTechnology()));
		return mv;
	}
	@RequestMapping(path="/searchMentorByTime")
	public String searchMentorByTime(Model model) throws Exception {
		Mentor mentor=new Mentor();
		model.addAttribute("mentor", mentor);
		return "searchMentorTime";
	}
	
	@RequestMapping(value = "/getMentorsByTime", method = RequestMethod.GET)
	public ModelAndView getMentorsByTime(Mentor mentor) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchMentorListTime");
		mv.addObject("mentorList",mentorservice.findByTime(mentor.getFromTime()));
		return mv;
	}

	@RequestMapping(path="/homePage")
	public String homePage(Model model) throws Exception {
		
		return "home";
	}
	
	@RequestMapping(value="/userMentorRequest")
    public String userMentorRequest(@RequestParam("mentorid") int mentorId,HttpSession session,HttpServletRequest request)
    {
		int id=(Integer) session.getAttribute("user");
         Status status=new Status();
        
         status.setUserId(id);
         status.setStatus("request");
         status.setMentorId(mentorId);
         statusservice.save(status);
         return "userHome";
        
    }
	
	@RequestMapping(path="/requestlist")
    public ModelAndView getRequestList(HttpSession session) throws Exception {
          ModelAndView mv=new ModelAndView();
          mv.setViewName("requestDetails");
         int m=  (Integer) session.getAttribute("mentorsession");
         
         mv.addObject("requestList",statusservice.findBymentorId(m));
          return mv;
    }

    @RequestMapping(value="/acceptRequest")
    public String acceptRequest(@RequestParam("userid") int userId,@RequestParam("mentorid") int mentorId)
    {
          
    	statusservice.acceptRequest(userId,mentorId);
    	return "redirect:/requestlist";
    }
    @RequestMapping(value="/rejectRequest")
    public String rejectRequest(@RequestParam("userid") int userId,@RequestParam("mentorid") int mentorId)
    {
          
    	statusservice.rejectRequest(userId,mentorId);
    	return "redirect:/requestlist";
    }
    @RequestMapping(path="/mentorHomePage")
	public String mentorHomePage(Model model) throws Exception {
		
		return "mentorHome";
	}

}

