package com.example.securityApp.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.securityApp.dao.FlatRepository;
import com.example.securityApp.model.FlatEntity;
import com.example.securityApp.util.FileUploadUtil;

@Service
public class FlatServiceImpl implements FlatService {

	
	@Autowired
	private FlatRepository flatRepository;
	
	@Override
	public FlatEntity add(FlatEntity flatentity, MultipartFile multipartFile) {
		flatentity.setSSN(UUID.randomUUID());
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		flatentity.setPhoto(fileName);
		FlatEntity savedFlatEntity = flatRepository.save(flatentity);
		String uploadDir = "visiter-photos/" + savedFlatEntity.getId();
		try {
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return savedFlatEntity;
	}

}
