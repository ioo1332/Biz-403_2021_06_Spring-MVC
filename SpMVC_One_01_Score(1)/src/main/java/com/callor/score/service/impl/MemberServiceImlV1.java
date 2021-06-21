package com.callor.score.service.impl;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.service.MemberService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberServiceImlV1 implements MemberService{

	@Override
	public StudentVO login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int join(StudentVO studentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int expire(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateInfo(StudentVO studentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
