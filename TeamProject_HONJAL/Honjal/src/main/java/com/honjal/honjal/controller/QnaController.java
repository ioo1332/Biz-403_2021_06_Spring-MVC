package com.honjal.honjal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/qna")
@Controller
public class QnaController {
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("BODY", "BOARD_MAIN");
		model.addAttribute("MENU", "QNA");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("BODY", "WRITE");
		model.addAttribute("MENU", "QNA");
		return "home";
	}
	
}
