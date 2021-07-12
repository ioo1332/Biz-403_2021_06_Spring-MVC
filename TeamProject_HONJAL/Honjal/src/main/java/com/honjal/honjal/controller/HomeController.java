package com.honjal.honjal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.service.ContentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	protected final ContentService contentService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<ContentListDTO> list = contentService.allContent();
		
		model.addAttribute("CONTENTS",list);
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
