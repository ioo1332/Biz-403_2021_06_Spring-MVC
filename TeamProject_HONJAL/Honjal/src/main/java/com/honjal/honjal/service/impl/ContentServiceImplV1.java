package com.honjal.honjal.service.impl;

import java.util.List;

import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.service.ContentService;

public class ContentServiceImplV1 implements ContentService {

	@Override
	public int insert(ContentVO contentVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ContentVO contentVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int content_num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ContentListDTO> listContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> menuContent(String board_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> searchTitleContent(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> searchTextContent(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> searchNameContent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentListDTO> MyContent(Integer member_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
