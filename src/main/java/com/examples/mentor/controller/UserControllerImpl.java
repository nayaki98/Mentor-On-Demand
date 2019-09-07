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
import org.springframework.web.servlet.ModelAndView;

import com.examples.mentor.model.Login;
import com.examples.mentor.model.Users;
import com.examples.mentor.service.LoginService;
import com.examples.mentor.service.StatusService;
import com.examples.mentor.service.UserService;

@Controller
public class UserControllerImpl {
	private String role="user";
    private  HttpSession session ;
	@Autowired
	private UserService userservice;
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	StatusService statusservice;
	
	@RequestMapping(path="/user")
	public String insert(Model model) throws Exception {
		Users users=new Users();
		model.addAttribute("users", users);
		return "userRegistration";
	}
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String submit(@ModelAttribute("users") @Valid Users users, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "userRegistration";
		}

		userservice.insertUser(users);
		loginservice.insertLoginDetails(new Login(users.getEmail(),users.getPassword(),role));
		return "redirect:/login";
	}
	

	@RequestMapping(path="/userRequeStatus")
    public ModelAndView getRequestStatus(HttpSession session,HttpServletRequest request) throws Exception {
                    ModelAndView mv=new ModelAndView();
                    mv.setViewName("userRequestStatus");
                    
                    int userId=  (Integer) session.getAttribute("user");
                    mv.addObject("userRequestList",statusservice.findByUserId(userId));
                    return mv;
    }

	@RequestMapping(path="/userList")
	public ModelAndView getuserList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userList");
		mv.addObject("userList",userservice.getuserList());
		return mv;
	}
	@RequestMapping(path="/userHomePage")
	public String userHomePage(Model model) throws Exception {
		
		return "userHome";
	}
}
	

