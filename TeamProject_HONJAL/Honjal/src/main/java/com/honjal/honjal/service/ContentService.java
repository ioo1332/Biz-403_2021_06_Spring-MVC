package com.honjal.honjal.service;

import java.util.List;

import org.springframework.ui.Model;

import com.honjal.honjal.model.BestContentVO;
import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.model.GoodVO;

public interface ContentService {
	
	public ContentVO findByIdContent(Integer content_num);
	// 글번호로 글찾기
	
	public void insert(ContentVO contentVO) throws Exception;
	// 글쓰기
	
	public void update(ContentVO contentVO) throws Exception;
	// 글수정
	
	public void delete(Integer content_num) throws Exception;
	// 글삭제
	
	
	public List<ContentListDTO> contentMenuAllPage(String board_code, int pageNum, Model model);
	// 페이지네이션 적용된 메뉴별 글 리스트 (각 게시판, 전체게시판에서도 사용)
	
	public int checkGood(GoodVO goodVO);
	
	public void insertGood(GoodVO goodVO);
	// 추천
	public void deleteGood(GoodVO goodVO);
	// 추천 취소
//	public int getGood(Integer content_num);
	// 추천수 조회
	
	
	public List<BestContentVO> bestContent();
	// [메인화면] 최근 일주일 인기글
	public List<ContentListDTO> infoContent();
	// [메인화면] 정보 게시판 글 랜덤 5개
	
	
	public int view_count(ContentVO contentVO);
	// 조회수

}
