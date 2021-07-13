package com.honjal.honjal.service;

import java.util.List;

import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;

public interface ContentService {
	
	public ContentVO findByIdContent(Integer content_num);
	
	public void insert(ContentVO contentVO) throws Exception;
	// 글쓰기
	
	public void update(ContentVO contentVO) throws Exception;
	// 글수정
	
	public void delete(Integer content_num) throws Exception;
	// 글삭제
	
	
	
	public List<ContentListDTO> allContent();
	// 올라오는 모든 글 리스트 (최신글목록에서 사용)
	
	public List<ContentListDTO> menuContent(String board_code);
	// 메뉴별 글 리스트 (각 게시판에서 사용)
	


	
	
	
	
	public List<ContentListDTO> searchTitleContent(String title);
	// 글검색 (제목으로)
	
	public List<ContentListDTO> searchTextContent(String text);
	// 글검색 (내용으로)
	
	public List<ContentListDTO> searchNameContent(String name);
	// 글검색 (작성자로)
	
	public List<ContentListDTO> MyContent(Integer member_num);
	// 내글검색

	void view_count(int content_view) throws Exception;

	List<ContentListDTO> menuContent(String board_code, int content_num) throws Exception;

	
	
}
