package com.artefact.service;

import org.springframework.web.multipart.MultipartFile;


public interface ArtefactServices {
	
	public String addProductImage(String name, MultipartFile file);
	
	public boolean removeProductImage(String imageLink);

}
