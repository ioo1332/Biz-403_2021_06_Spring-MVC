package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequestMapping("/score")
@Controller
@RequiredArgsConstructor
@Slf4j
public class ScoreController {
	
	protected final ScoreService scService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String scoreList(Model model) {
		List<ScoreDTO>scoreList=scService.scoreAllList();
		model.addAttribute("SCORES",scoreList);
		
		model.addAttribute("BODY","SCORE_VIEW");
		return "home";
		
		
	}
	
	
	

}
