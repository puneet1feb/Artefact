package com.artefact.service;

import org.springframework.web.multipart.MultipartFile;


public interface ArtefactServices {
	
	public String addProductImage(MultipartFile file);

}