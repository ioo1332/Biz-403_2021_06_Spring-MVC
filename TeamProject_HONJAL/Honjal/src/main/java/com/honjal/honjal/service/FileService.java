package com.honjal.honjal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	
	public List<String>fileUp(MultipartHttpServletRequest file)throws Exception;

	public List<String> fileUp(MultipartFile file)throws Exception;

	List<String> fileUp(MultipartFile file, MultipartHttpServletRequest files) throws Exception;
	
	

}
