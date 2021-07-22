package com.honjal.honjal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.honjal.honjal.dao.ext.CommentDao;
import com.honjal.honjal.model.CommentVO;
import com.honjal.honjal.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("commentServiceV1")
public class CommentServiceImplV1 implements CommentService{

	protected final CommentDao commentDao;
	
	@Override
	public void insert(CommentVO commentVO) {
		// TODO Auto-generated method stub
		commentDao.insert(commentVO);
	}

	@Override
	public void update(CommentVO commentVO) {
		// TODO Auto-generated method stub
		commentDao.update(commentVO);
		
	}

	@Override
	public void delete(Integer comment_num) {
		// TODO Auto-generated method stub
		commentDao.delete(comment_num);
		
	}

	@Override
	public List<CommentVO> selectAll() {
		// TODO Auto-generated method stub
		List<CommentVO> commentList = commentDao.selectAll();
		return commentList;
	}

}