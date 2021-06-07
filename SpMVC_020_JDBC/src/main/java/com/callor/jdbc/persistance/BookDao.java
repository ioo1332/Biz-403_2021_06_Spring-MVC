package com.callor.jdbc.persistance;

import java.util.List;

import com.callor.jdbc.model.BookVO;

/* Dao(data access object)
 * service -> dao ->DBMS과정에서 실질적인 한개 table에서 crud를 담당할 interface,class
 * servlet project에서 service가 실행했던 역할을 dao가 실행하게 된다
 */
public interface BookDao extends GenericDao<BookVO, String>{
	// Generic에 선언된 method를 추가하여 도서정보 테이블에서 조회할 여러가지 method를 작성
	// 도서명 검색하기
	public List<BookVO> findByName(String name);
	// 출판일로 검색하기
	public List<BookVO> findByDate(String date);
	
	public List<BookVO> findByComp(String comp);
	public List<BookVO> findByAuthor(String author);	
	

}
