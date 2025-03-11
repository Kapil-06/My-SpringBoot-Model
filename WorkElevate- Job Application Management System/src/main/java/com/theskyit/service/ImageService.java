package com.theskyit.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.model.Image;

public interface ImageService {

	ResponseEntity<?> saveImage(MultipartFile file);

	//List<Image> getImage(List<String> ids);

	boolean deleteImage(String id);

	List<Image> getImage(List<String> ids);

	List<Image> getAllImages();

}
