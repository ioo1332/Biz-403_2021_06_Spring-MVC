package com.honjal.honjal.service.impl;

import java.util.List;

import javax.inject.Inject;

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
	
	protected final ContentDao contDao;
	private SqlSession sqlSession;
	

	
	

	@Override
	public int insert(ContentVO contentVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ContentVO contentVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int content_num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ContentListDTO> listContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> menuContent(String board_code) {
		// TODO Auto-generated method stub
		return null;
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
	public void read_count(int content_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("write-mapper.board_Count", content_num);
	}

	// 글 조회
		@Transactional(isolation = Isolation.READ_COMMITTED)
		@Override
		public ContentVO read(int content_num) throws Exception {
				contDao.board_Count(content_num);
			return ((ContentService) contDao).read(content_num);
		}



}
