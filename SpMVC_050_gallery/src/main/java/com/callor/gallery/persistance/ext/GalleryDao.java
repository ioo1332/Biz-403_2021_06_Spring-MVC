package com.callor.gallery.persistance.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.persistance.GenericDao;

public interface GalleryDao extends GenericDao<GalleryDTO, Long>{
	
	public List<GalleryFilesDTO>findByIdGalleryFiles(Long g_seq);
	
	public GalleryDTO findByIdGalleryFilesResultMap (Long g_seq);

	public int countAll();

	/*
	 * mapper에 전달하는 변수가 2개이상일경우
	 * 반드시 @param을 사용하여 변수명을 명시해줘야한다
	 * mapper에서는 @param으로 지정된 변수명을 사용하여 처리를 해야한다
	 */
	public List<GalleryDTO> findBySearch(@Param("column") String search_column, 
			@Param("text") String search_text);

}
