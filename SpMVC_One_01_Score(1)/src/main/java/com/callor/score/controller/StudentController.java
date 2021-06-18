package com.callor.score.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String list (HttpSession hSession,Model model) {
		
		return "student/list";
	}

}
