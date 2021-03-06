package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("scoreServiceV1")
@RequiredArgsConstructor
@Slf4j
public class ScoreSerivceImplV1 implements ScoreService{

	protected final ScoreDao scDao;


	@Override
	public List<ScoreDTO> scoreAllList() {
		List<ScoreDTO>scoreList=scDao.selectViewAll();
		log.debug("Score{}",scoreList.toString());
		return scoreList;
	}


	@Override
	public List<SubjectAndScoreDTO> selectScore(String stNum) {
		// TODO Auto-generated method stub
		List<SubjectAndScoreDTO>ssList=scDao.selectSubjectAndScore(stNum);
		
		return ssList;
	}
	
	

}
