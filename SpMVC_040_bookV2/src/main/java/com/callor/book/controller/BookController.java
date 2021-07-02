package com.callor.book.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/book")
@Controller
public class BookController {

	
	protected final BookService bookService;
	
	@RequestMapping(value="/insert/{isbn}",method=RequestMethod.GET)
	public String insert(
			@PathVariable("isbn") String isbn, Model mode) throws IOException, ParseException {
		
		log.debug("ISBN : {}",isbn);
		
		int ret = bookService.insert(isbn);
		return "redirect:/naver/BOOK";
	}
	@RequestMapping(value = "/book/list",method =RequestMethod.GET)
	public String bookList(Model model) {
		List<BookDTO>bookList=bookService.selectAll();
		model.addAttribute("BOOKS",bookList);
		model.addAttribute("BODY","BOOK_LIST");
		
		return "home";
		
	}
	
	
}