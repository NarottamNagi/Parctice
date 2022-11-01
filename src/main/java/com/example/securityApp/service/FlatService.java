package com.example.securityApp.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.securityApp.model.FlatEntity;

public interface FlatService {
	
	public FlatEntity add(FlatEntity flatentity, MultipartFile multipartFile);

}
