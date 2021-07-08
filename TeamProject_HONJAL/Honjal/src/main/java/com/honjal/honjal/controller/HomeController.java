package com.honjal.honjal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY", "JOIN");
		return "home";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Model model) {
		
		model.addAttribute("BODY", "READ");
		return "home";
	}
	
	@RequestMapping(value = "/scrap", method = RequestMethod.GET)
	public String scrap(Model model) {
		
		model.addAttribute("BODY", "SCRAP");
		return "home";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String write_admin(Model model) {
		
		model.addAttribute("BODY", "WRITE_ADMIN");
		return "home";
	}
	
}
