package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/student")
public class StudentController {
	
	protected final StudentService stService;
	//protected final ScoreService scService;
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String studentList(Model model) {
		List<StudentVO>stList=stService.selectAll();
		model.addAttribute("STUDENTS",stList);
		model.addAttribute("BODY","STUDENT_LIST");
		
		return "home";
		
	}
	
	@RequestMapping(value= {"/insert"},method=RequestMethod.GET)
	public String insert(Model model) {
		StudentVO stVO=new StudentVO();
		stVO.setSt_num(stService.makeStNum());
		model.addAttribute("STD",stVO);
		model.addAttribute("BODY","STUDENT_INPUT");
		return "home";
		
	}
	@RequestMapping(value= {"/insert"},method=RequestMethod.POST)
	public String insert(StudentVO studentVO, Model model) {
		log.debug("Req 학생정보:{}",studentVO.toString());
		int ret=stService.insert(studentVO);
		
		model.addAttribute("BODY","STUDENT_INPUT");
		return "redirect:/student";
	}
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public String detail(String st_num,Model model) {
	//	List<SubjectAndScoreDTO> ssList=scService.selectScore(st_num);
		//model.addAttribute("SSLIST",ssList);
		String ret=stService.detail(model,st_num);
		model.addAttribute("BODY","STUDENT_DETAIL");
		return "home";
	}
	@RequestMapping(value="/detail",method = RequestMethod.POST)
//	public String detail(
//			@RequestParam(name="subject")List<String>subject,
	//		@RequestParam(name="score")List<String>score) {
	public String detail(ScoreInputVO scInputVO,Model model) {
		//log.debug("Subject:{}",subject.toString());
		//log.debug("score:{}",score.toString());
		log.debug("Score Input{}",scInputVO.toString());
		String ret=stService.scoreInput(scInputVO);
		String st_num=scInputVO.getSt_num();
		/*
		 * redirect를 수행할때 query string 을 보내고 싶으면
		 * 해당 변수와 값을 model에 속성(attribut)로 추가
		 * 
		 * redirect:/student/detail?st_num="+st_num
		 * 같이 사용하지 않아도 된다
		 */
		
		model.addAttribute("st_num",st_num);
		
		return "redirect:/student/detail";
	}
	
	
}
