package com.callor.score.service;

import com.callor.score.model.StudentVO;

public interface MemberService {
	
	public StudentVO login(String username,String password);
	
	public int updateInfo(StudentVO studentVO);
	public int join(StudentVO studentVO);
	public int expire(String username);
	
	

}
