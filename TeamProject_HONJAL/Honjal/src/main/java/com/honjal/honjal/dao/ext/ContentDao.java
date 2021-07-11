package com.honjal.honjal.dao.ext;

import org.apache.ibatis.annotations.Param;

import com.honjal.honjal.dao.GenericDao;
import com.honjal.honjal.model.ContentVO;

public interface ContentDao extends GenericDao<ContentVO, Integer>{
	
	public void board_Count(int content_num) throws Exception;

	
}
	
