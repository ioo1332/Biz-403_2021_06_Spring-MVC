package com.honjal.honjal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.honjal.honjal.dao.ext.ContentDao;
import com.honjal.honjal.dao.ext.FileDao;
import com.honjal.honjal.model.ContentDTO;
import com.honjal.honjal.model.ContentFilesDTO;
import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.model.FileDTO;
import com.honjal.honjal.service.ContentService;
import com.honjal.honjal.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service("contentServiceV1")
public class ContentServiceImplV1 implements ContentService {

	protected final ContentDao contentDao;
	protected final SqlSession sqlSession;
	protected final FileDao fDao;
	
	@Qualifier("fileServiceV2")
	protected final FileService fService;
	
	@Override
	public ContentVO findByIdContent(Integer content_num) {
		ContentVO contentVO = contentDao.findByIdContent(content_num);
		return contentVO;
	}
	
	@Override
	public void insert(ContentVO contentVO) throws Exception {
		contentDao.insert(contentVO);
		return;
	}

	@Override
	public void update(ContentVO contentVO) throws Exception {
		contentDao.update(contentVO);
		return;
	}

	@Override
	public void delete(Integer content_num) throws Exception {
		contentDao.delete(content_num);
		return;
	}
	
	@Override
	public List<ContentListDTO> allContent() {
		List<ContentListDTO> list = contentDao.allContent();
		return list;
	}

	@Override
	public List<ContentListDTO> menuContent(String board_code) {
		List<ContentListDTO> contentList = contentDao.menuContent(board_code);
		return contentList;
	}
	
	@Override
	public List<ContentListDTO> menuContentPage(String board_code, int pageNum) {
		List<ContentListDTO> contentList = contentDao.menuContent(board_code);
		int total = contentList.size();
		int start = (pageNum-1) * 10;
		int end = pageNum * 10;
		
		List<ContentListDTO> pageList = new ArrayList<ContentListDTO>();
		
		for (int i = start; i < end; i++) {
			pageList.add(contentList.get(i));
		}
		
		
		
		return pageList;
	}

	@Override
	public List<ContentListDTO> searchTitleContent(String menu, String search_word) {
		List<ContentListDTO> list = contentDao.searchTitleContent(menu, search_word);
		return list;
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
	
	@Override
	public List<ContentFilesDTO> findByIdGalleryFiles(Long g_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentFilesDTO findByIdGallery(Long g_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void input(ContentDTO contentDTO, MultipartFile one_file, MultipartHttpServletRequest m_file)
			throws Exception {
		// TODO Auto-generated method stub
		String strUUID = fService.fileUp(one_file);
		contentDTO.setFile_image(strUUID);
		log.debug(" INSERT 전 seq {}", contentDTO.getContent_num());
		contentDao.insert(contentDTO);
		log.debug(" INSERT 후 seq {}", contentDTO.getContent_num());
		Long content_num=contentDTO.getContent_num();
		List<FileDTO> files = new ArrayList<FileDTO>();
		List<MultipartFile>mFiles=m_file.getFiles("m_file");
		for(MultipartFile file : mFiles) {
			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);
			FileDTO fDTO = FileDTO.builder()
							.content_num(content_num)
							.file_original(fileOriginName)
							.file_upname(fileUUName)
							.build();
			files.add(fDTO);
		}
		fDao.insertOrUpdateWithList(files);
	}
	
	// 조회수
		@Override
		public void view_count(int content_num) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		// 제목옆댓글수
		@Override
		public void comment_count(int content_view) throws Exception {
			
		}


}
