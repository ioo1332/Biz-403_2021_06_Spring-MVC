package com.callor.hello.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/*
 * Spring 프로젝트에서 클래스를 선언하고 각 클래스에 sterotype을 부착
 * sterotype: Conponent,Controller,Service,Repository...
 * 각 클래스에 sterotype을 부착하는순간 spring에게 
 * 이 컨테이너에 보관해달라고 요청하는것
 * 이 클래스들을 객체로 생성하여 보관하고 있어달라
 *  */

@Controller
@Service
public class HomeService {
	
	public Integer add(int num1, int num2) {
		return num1 + num2;
	}

}
