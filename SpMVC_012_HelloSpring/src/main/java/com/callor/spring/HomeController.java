package com.callor.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger("HomeController");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// logger의 method들 
		// 이 method들을 logger에서는 level이라고 부른다
		
		// logback_test.xml의 level을 info로 설정을하면
		// 코드 곳곳에 logger.trce(),logger.debug()로 출력한곳은 모두 코드가 무시된다. 위치가 level
		logger.trace("트레이스");
		logger.debug("디버그");
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.warn("워닝");
		logger.error("에러");
		logger.debug(String.valueOf(300*400));
		logger.debug("여기는 HOME CONTROLLER return 바로위");
		return "home";
	}

}
