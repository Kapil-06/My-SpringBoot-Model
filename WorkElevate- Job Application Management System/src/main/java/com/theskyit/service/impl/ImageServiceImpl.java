package com.theskyit.service.impl;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.model.Image;
import com.theskyit.repository.ImageRepository;
import com.theskyit.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private final ImageRepository imageRepository;
	
	public ImageServiceImpl(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	public ResponseEntity<?> saveImage(MultipartFile file) {
		Image image = new Image();	
		try {
			image.setName(file.getOriginalFilename());
			image.setData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(imageRepository.save(image));
	}
	
	@Override
	public List<Image> getImage(List<String> ids) {
	    return imageRepository.findAllById(ids);
	}
	
	@Override
	public List<Image> getAllImages(){
		return imageRepository.findAll();
	}
	
	@Override
	public boolean deleteImage(String id) {
		if(imageRepository.existsById(id)) {
			imageRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
