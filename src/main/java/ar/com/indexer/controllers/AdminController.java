package ar.com.indexer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(value = "/adminAddUser.htm", method = RequestMethod.POST)
	public ModelAndView printWelcome(ModelMap model) {

		ModelAndView mav = new ModelAndView("/test/resultao");
		mav.addObject("resultado","entraste iupi!gil!");
		return mav;

	}

}
