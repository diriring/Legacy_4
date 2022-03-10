package com.java.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public String save(MultipartFile multipartFile, String path) throws Exception {
		//1. 어디에 저장할건지 path="/resources/upload/member"
		//파일저장은 tomcat이 아니라 OS에서 저장
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		if(!file.exists()) {
			//file.mkdir(); //중간 폴더가 없으면 에러 발생
			file.mkdirs(); //중간 폴더가 없으면 중간 폴더도 생성
		}
		
		//1. 시간을 이용한 파일명 생성
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis(); //현재 시간을 밀리세컨즈로 변환
		System.out.println("time : " + l);
		
		String oriName = multipartFile.getOriginalFilename();
		String fileName = l + "_" + oriName;
		System.out.println("fileName : " + fileName);
		
		//2. UUID를 이용한 파일명 생성
		fileName = UUID.randomUUID().toString(); //static이 들어간 class method라서 객체 생성하지 않고 method를 쓸 수 있음
		fileName = fileName + "_" + oriName;
		System.out.println("UUID : " + fileName);
		
		//file을 HDD에 저장
		//1. MultipartFile의 transferTo 사용
//		file = new File(realPath, fileName);
//		multipartFile.transferTo(file);
		
		//2. FileCopyUtils
		file = new File(realPath, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}

}
