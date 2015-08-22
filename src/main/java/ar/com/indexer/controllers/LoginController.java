package ar.com.indexer.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	@RequestMapping(value="/logearse.htm", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
	
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security login + database example");
		return "hello";
 
	}
 
	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
 
		ModelAndView mav = new ModelAndView("/fueraLogin/landingPage");
		return mav;
 
	}
	
	@RequestMapping(value="/loginfailed.htm", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelMap model) {
 
		ModelAndView mav = new ModelAndView("login/inicio");
		mav.addObject("error","true");
		return mav;
 
	}
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model) {
 
		ModelAndView mav = new ModelAndView("/login/logout");
		
		return mav;
 
	}
	

}
