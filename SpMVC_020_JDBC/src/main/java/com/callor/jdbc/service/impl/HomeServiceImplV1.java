package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.model.HomeService;
import com.callor.jdbc.service.AuthorService;
import com.callor.jdbc.service.BookService;
import com.callor.jdbc.service.CompService;

import lombok.RequiredArgsConstructor;
/*
 * private final,protected final로 선언된
 * 필드 맴버 변수를 초기화하는 코드를 갖는 생성자를 만들어준다
 */
@RequiredArgsConstructor
@Service("homeServiceV1")
public class HomeServiceImplV1 implements HomeService{
	
	protected final BookService bookService;
	protected final AuthorService auService;
	protected final CompService cpService;
	
	@Override
	public void dashBoard(Model model) {
		// TODO Auto-generated method stub
		List<BookVO>bookList=bookService.selectAll();
		List<AuthorVO>authorList=auService.selectAll();
		List<CompVO>compList=cpService.selectAll();
		/*
		 * 3개의 dao로 부터 데이터를 받아서 controller로 return하려면 상당히 불편한 상황이 연출될수있다
		 * 
		 * 이때 controller로부터 model객체를 매개변수로 받아서 model객체에 attribute를 추가하면
		 * controller의 원래 model에도 attribute가 추가되는 효과를 낼수있다
		 * call by refernece 처럼 작동한느 java의 객체 성질을 활용하기
		 */
		model.addAttribute("BOOKS",bookList);
		model.addAttribute("AUTHOS",authorList);
		model.addAttribute("COMPS",compList);
		
		
		
		
	}



	
	
	

}
