package com.honjal.honjal.dao.ext;

import java.util.Map;

import com.honjal.honjal.dao.GenericDao;
import com.honjal.honjal.model.MemberVO;

public interface MemberDao extends GenericDao<MemberVO, String>{

	public int insertOrUpdate(MemberVO memberVO);
	public int create_table(Map<String,String> resultMaps);

}