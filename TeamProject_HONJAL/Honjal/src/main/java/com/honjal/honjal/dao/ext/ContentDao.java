package com.honjal.honjal.dao.ext;

import java.util.List;

import com.honjal.honjal.dao.GenericDao;
import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;

<<<<<<< HEAD
public interface ContentDao extends GenericDao<ContentVO, Integer> {

	public ContentVO findByIdContent(Integer content_num);

	public List<ContentListDTO> allContent();

	public List<ContentListDTO> menuContent(String board_code);

	public void insert(ContentVO contentVO);

	public void update(ContentVO contentVO);

	public void delete(Integer content_num);

	public void view_count(int content_num) throws Exception;

=======
public interface ContentDao extends GenericDao<ContentVO, Integer>{

	public ContentVO findByIdContent(String content_num);
	
	public List<ContentListDTO> allContent();
	public List<ContentListDTO> menuContent(String board_code);
	
	public void insert(ContentVO contentVO);
	public void update(ContentVO contentVO);
	public void delete(Integer content_num);

	
	public void view_count(int content_num) throws Exception;
	
	
	
	
>>>>>>> 21d7e07642e54534aee1027cf88a5f13d45b6750
}
