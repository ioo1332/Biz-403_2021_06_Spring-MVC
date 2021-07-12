package com.honjal.honjal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.service.ContentService;

import lombok.RequiredArgsConstructor;
@RequestMapping("/read")
@RequiredArgsConstructor
@Controller
public class ContentController {
	
	protected final ContentService contentService;
	
	@RequestMapping(value="/read" , method = RequestMethod.GET)
	public String read(String board_code, Model model) {
		
		// 전체글목록에서 글 클릭하면 그 게시판의 read로 넘어가게
		
		return "home";
	}
	
	


	
}
