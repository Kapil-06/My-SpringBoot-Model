package com.theskyit.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.model.ApiResponse;
import com.theskyit.model.Image;
import com.theskyit.service.ImageService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/image")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imageService;

    // Map to store file extensions and their corresponding MediaType
    private static final Map<String, MediaType> MEDIA_TYPE_MAP = new HashMap<>();

    static {
        MEDIA_TYPE_MAP.put("png", MediaType.IMAGE_PNG);
        MEDIA_TYPE_MAP.put("jpg", MediaType.IMAGE_JPEG);
        MEDIA_TYPE_MAP.put("jpeg", MediaType.IMAGE_JPEG);
        // Add more mappings if needed
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, HttpSession session) {
        String username = (String) session.getAttribute("username");
        logger.info("Username in session: {}", username);
        if (username == null) {
            logger.warn("Unauthorized access attempt");
            return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
        }
        logger.info("Uploading image for user: {}", username);
        return ResponseEntity.status(HttpStatus.OK).body(imageService.saveImage(file));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getImages(@RequestParam(required = false) List<String> ids, HttpSession session) {
        String username = (String) session.getAttribute("username");
//        if (username == null) {
//            logger.warn("Unauthorized access attempt to fetch images");
//            return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
//        }

        logger.info("User '{}' attempting to fetch images with IDs: {}", username, ids);

        try {
            List<Image> images;
            if (ids == null || ids.isEmpty()) {
                logger.info("Fetching all images for user: {}", username);
                images = imageService.getAllImages(); // Fetch all images
            } else {
                logger.info("Fetching specific images for user: {} with IDs: {}", username, ids);
                images = imageService.getImage(ids); // Fetch specific images by IDs
            }

            if (images == null || images.isEmpty()) {
                logger.info("No images found for user: {}", username);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No images found");
            }

            List<Map<String, Object>> responseEntities = new ArrayList<>();
            for (Image image : images) {
                String fileName = image.getName();
                byte[] imageData = image.getData();

                if (fileName == null || imageData == null) {
                    logger.warn("Skipping invalid image for user: {}", username);
                    continue; // Skip invalid images
                }

                // Convert image data to Base64
                String base64ImageData = Base64.getEncoder().encodeToString(imageData);
                // Create response object
                Map<String, Object> imageResponse = new HashMap<>();
                imageResponse.put("statusCodeValue", HttpStatus.OK.value());
                imageResponse.put("body", Map.of(
                    "id", image.getId(),
                    "name", fileName,
                    "data", base64ImageData
                ));
                responseEntities.add(imageResponse);
            }

            logger.info("Successfully fetched {} images for user: {}", responseEntities.size(), username);
            return ResponseEntity.ok(responseEntities);
        } catch (Exception e) {
            logger.error("Error fetching images for user: {}", username, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching images: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable String id) {
        logger.info("Deleting image with ID: {}", id);
        if (imageService.deleteImage(id)) {
            logger.info("Image with ID: {} deleted successfully", id);
            return ResponseEntity.ok().build();
        } else {
            logger.warn("Image with ID: {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}