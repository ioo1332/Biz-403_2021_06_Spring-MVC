package com.honjal.honjal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.honjal.honjal.service.FileService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService{
	
	protected final String winPath;
	protected final String macPath;
	protected String fileUpPath;
	

	@Autowired
	private ResourceLoader resLoader;

	@Override
	public List<String> fileUp(MultipartFile file)throws Exception {
		// TODO Auto-generated method stub
	
		return null;
	}


	@Override
	public List<String> fileUp(MultipartFile file, MultipartHttpServletRequest files)throws Exception {
		// TODO Auto-generated method stub
		String originaFileName = file.getOriginalFilename();
		List<String>fileNames=new ArrayList<String>();
		String tagName="files";
		List<MultipartFile>fileList=file.getFiles(tagName);
		
		for(MultipartFile fire:fileList) {
			String fileName=this.fileUp(file);	
			fileNames.add(fileName);
		}
		return fileNames;
	}
	

}
