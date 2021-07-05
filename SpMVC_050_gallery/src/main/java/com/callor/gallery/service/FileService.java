package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	// 1개의 파일을 upload하고 upload한 파일 이름을 return
	public String fileUp(MultipartFile file) throws Exception;
	// 다수의 파일을 upload하고 upload후 파일들 이름을 return
	public List<String> filesUP(MultipartHttpServletRequest files)throws Exception;
	


}
