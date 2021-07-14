package com.honjal.honjal.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("fileServiceV2")
public class FileServiceImplV2 extends FileServiceImplV1{
	
	protected final String winPath;
	protected String fileUpPath;
	
	@Autowired
	public void getFilePath(String winPath){
		
		this.fileUpPath=this.winPath;
	}
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		String originalFileName=file.getOriginalFilename();
		if(originalFileName==null||originalFileName.isEmpty()) {
			return "";
		}
		File path=new File(fileUpPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		String strUUID=UUID.randomUUID().toString();
		strUUID +=originalFileName;
		File uploadPathAdndFile=new File(fileUpPath,strUUID);
		file.transferTo(uploadPathAdndFile);
		return strUUID;
		
	}
	
	
	
	



}
