package com.callor.jdbc.pesistance.impl;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;
@Service("compServiceV1")
@Slf4j	
public class CompServiceImplV1 implements CompService{
	
	protected final CompDao compDao;
	
	public CompServiceImplV1(CompDao compDao) {
		// TODO Auto-generated constructor stub
		this.compDao=compDao;
	}

	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String cpCode=compDao.findByMaxCode();
		log.debug("Cpcode {}",cpCode);
		if(cpCode==null || cpCode.equals("")) {
			// C0001문자열 만들기
			cpCode=String.format("C%04d",1);
		}else {
			//영문 접두사 C를 자르고 숫자만 추출
			String _code=cpCode.substring(1);
			// 코드 증가 생성
			Integer intCode=Integer.valueOf(_code)+1;
			cpCode=String.format("C%04d", intCode);
		}
		
		vo.setCp_code(cpCode);
		compDao.insert(vo);
		return 0;
	}

}
