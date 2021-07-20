package com.callor.ajax;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.ajax.model.UserDTO;

@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "home";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String json(Model model) {
	
		return "json";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
	
		return "form";
	}
	/*
	 * web client와 JSON데이터 교환하기
	 * WEB 에서 JSON데이터를 보내면
	 * Controller에서는 @RequestBody속성을 사용하여 데이터를 받고
	 * WEB에서 다시 JSON 데이터를 return하기 위해선 @ResponseBody속성을 사용하여 데이터를 return한다
	 */
	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public String json(@RequestBody String user_id, Locale locale, Model model) {
	
		return user_id;
	}
	/*
	 * controller에서 web으로 보낸데이터가 2가지 이상의 변수에 해당하면
	 * 무조건 vo dto를 만들어서 받아라
	 * 
	 * @RequestBody는 jackson bind에 의해서
	 * web에서 전달된 json데이터를 dto클래스에 binding한다
	 * spring 4.x에서는 jackson bind가 기본으로 포함이 되었었다
	 * spring 5.x에서는 jackson bind가 분리되어서
	 * pom.xml에서 jackson bind를 포함시켜줘야 한다
	 */
	
	@ResponseBody
	@RequestMapping(value = "/json/dto", method = RequestMethod.POST)
	public UserDTO json(@RequestBody UserDTO userDTO, Model model) {
		System.out.println("web에서 받은데이터:");
		System.out.println(userDTO.toString());
		return userDTO;
	}
	@ResponseBody
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public UserDTO form(@RequestBody UserDTO userDTO, Model model) {
	
		return userDTO;
	}
	
}
