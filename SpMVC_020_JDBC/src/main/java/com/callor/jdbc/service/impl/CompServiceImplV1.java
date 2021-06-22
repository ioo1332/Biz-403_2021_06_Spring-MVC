package com.callor.jdbc.service.impl;

import java.util.List;

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
			// C0001문자열 자동으로 만들기
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

	@Override
	public List<CompVO> findByCName(String cp_name) {
		// TODO Auto-generated method stub
		// 전달받은 출판사 이름에서 앞뒤의 빈칸을 제거하고
		// Dao에게 Toss 한후 출판사 리스트를 받아 다시 return
		return compDao.findByCName(cp_name.trim());
		
		
	}

	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub
		return compDao.selectAll();
	}

	@Override
	public CompVO findByCCode(String cp_code) {
		// TODO Auto-generated method stub
		return compDao.findById(cp_code.trim());
	}
	

	@Override
	public List<CompVO> findByTitleAndCeoAndTel(String text) {
		List<CompVO>mainList=compDao.findByCName(text);
		List<CompVO>ceoList=compDao.findByCeo(text);
		List<CompVO>telList=compDao.findByTel(text);
		mainList.addAll(ceoList);
		mainList.addAll(telList);
		return mainList;
	}

	
	

}
