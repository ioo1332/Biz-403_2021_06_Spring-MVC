package com.callor.score.pesistance;

public interface UserDAO<UserVO, String> {
	
	public int insert();
	public int update();
	public int delete();
	

}
