package com.callor.book.exec;

import com.callor.book.model.BookDTO;

public class Main_01 {
	
	public static void main(String[] args) {
		
		// VO, DTO 를 생성하고 데이터를 담기
		// 1. 빈(blank)객체를 생성하고, 필요한 값을 setter를 사용하여 값을 저장하기
		// 필요한 개수만큼 setter method를 계속 나열해야한다
		BookDTO bookDTO=new BookDTO();
		bookDTO.setTitle("자바야놀자");
		// 2. 필드 생성자를 사용하여 객체를 생성하면서 값을 주입하는 방법
		// 일부 데이터만 주입하여 객체를 생성할수없다 일부데이터를 위하여 별도로 생성자를 또 만들어야한다
		// 데이터의 주입 순서가 바뀌면 어떤 값이 저장될지 모른다 (전적으로 개발자 책임으로 귀결됨)
		BookDTO bookDTO1=new BookDTO("자바야놀자","link","image","author","price",
				"discount","publisher","isbn","desc","pubdate");
		// 3. Builder패턴
		// 객체를 생성(초기화)할때 new 키워드를 사용하지 않고 내부에 만들어져있는 builder method를 먼저 호출
		// builder method는 객체를 생성하여 return하는 코드
		// 필요한 변수를 setting할때 setter method를 사용하지않고 변수명()형태의 method를 사용하여 값을 저장
		// 값이 저장되고 생성된 객체를 사용할수 있도록 객체 인스턴스 (bookDTO02)에게 전달하기 위하여 
		// build()method를 호출한다
		
		// new 키워드로 생성자를 호출하지 않는다 필요한 변수(속성,맴버변수)만 가지고있는 객체를 만들수있다
		// 변수이름을 직접 호출하는 방식으로 값을 저장할수있다
		BookDTO bookDTO02=BookDTO.builder().title("자바야놀자").price("20000").isbn("9760000").build();
		
		System.out.println(bookDTO02.toString());
		
		
	}

}
