package com.examples.mentor.controller;

import java.util.List;

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
import com.examples.mentor.model.Mentor;
import com.examples.mentor.model.Users;
import com.examples.mentor.service.LoginService;
import com.examples.mentor.service.MentorService;
import com.examples.mentor.service.UserService;

@Controller
public class LoginControllerImpl {
	/* private HttpSession session ; */
	@Autowired
	private LoginService loginservice;

	@Autowired
	private UserService userervice;

	@Autowired
	private MentorService mentorervice;

	@RequestMapping(path = "/login")
	public String loginUser(Model model) throws Exception {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	@RequestMapping(value = "/loginVerification", method = RequestMethod.GET)
	public ModelAndView userVerification(@ModelAttribute("login") @Valid Login login, BindingResult result, Model model,
			HttpSession session, HttpServletRequest request) {
		ModelAndView mav = null;
		if (result.hasErrors()) {

			mav = new ModelAndView("login");
		}

		String email = login.getEmail();
		List<Login> login1 = loginservice.findByemail(email);
		Login login2 = login1.get(0);
		if ((login.getEmail().equals(login2.getEmail())) && (login.getPassword().equals(login2.getPassword()))) {
			Users user1 = userervice.findByemail(email);
			Mentor mentor1 = mentorervice.findByemail(email);

			if (login2.getRole().equals("user")) {
				session = request.getSession();
				session.setAttribute("user", user1.getUserId());

				model.addAttribute("mentor", new Mentor());
				mav = new ModelAndView("searchMentorTechnology");
			} else if (login2.getRole().equals("mentor")) {
				session = request.getSession();
				session.setAttribute("mentorsession", mentor1.getMentorId());
				mav = new ModelAndView("mentorHome");
			}
			

		} else {
			login.setEmail(null);
			login.setPassword(null);
			mav = new ModelAndView("login", "message", "Invalid");
		}
		return mav;

	}
	
}
