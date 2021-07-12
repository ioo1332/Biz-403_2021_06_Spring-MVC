package com.honjal.honjal.dao;

import java.util.List;

public interface GenericDao<VO, PK> {
	public List<VO> selectAll();
	public VO findById(PK pk);
	
	public void insert(VO vo);
	public void update(VO vo);
	public void delete(PK pk);
}
