package com.honjal.honjal.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.honjal.honjal.dao.ext.ContentDao;
import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.service.ContentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("contentServiceV1")
public class ContentServiceImplV1 implements ContentService {

	protected final ContentDao contentDao;
	protected final SqlSession sqlSession;

	@Override
	public ContentVO findByIdContent(String content_num) {
		ContentVO contentVO = contentDao.findByIdContent(content_num);
		return contentVO;
	}

	@Override
	public void insert(ContentVO contentVO) throws Exception {
		contentDao.insert(contentVO);
		return;
	}

	@Override
	public void update(ContentVO contentVO) throws Exception {
		contentDao.update(contentVO);
		return;
	}

	@Override
	public void delete(Integer content_num) throws Exception {
		contentDao.delete(content_num);
		return;
	}

	@Override
	public List<ContentListDTO> allContent() {
		List<ContentListDTO> list = contentDao.allContent();
		return list;
	}

	@Override
	public List<ContentListDTO> menuContent(String board_code) {
		// TODO Auto-generated method stub
		List<ContentListDTO> contentList = contentDao.menuContent(board_code);
		return contentList;
	}

	@Override
	public List<ContentListDTO> searchTitleContent(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> searchTextContent(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> searchNameContent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> MyContent(Integer member_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void view_count(int content_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("content-mapper.view_count", content_num);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public List<ContentListDTO> menuContent(String board_code, int content_num) throws Exception {
		List<ContentListDTO> contentList = contentDao.menuContent(board_code);
		contentDao.view_count(content_num);
		return contentList;
	}

}
