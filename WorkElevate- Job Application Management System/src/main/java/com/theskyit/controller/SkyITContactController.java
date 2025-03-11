package com.theskyit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theskyit.dto.BusinessContactDTO;
import com.theskyit.dto.HRContactDTO;
import com.theskyit.dto.SkyITContactDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.model.SkyITContact;
import com.theskyit.service.SkyITContactService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/contact")
public class SkyITContactController {
	
	@Autowired
	private final SkyITContactService contactService;
	
	private final Logger logger = LoggerFactory.getLogger(SkyITContactController.class); 
	
	public SkyITContactController(SkyITContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@PostMapping("/submit-contact")
    public ResponseEntity<ApiResponse<?>> saveHRContact(@Valid @RequestBody SkyITContactDTO contactDTO, BindingResult result, HttpSession session) {
        logger.info("Received request to save contact: {}", contactDTO);
        if (result.hasErrors()) {
            logger.error("Validation failed for contact: {}", contactDTO);
            return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Validation failed", false), HttpStatus.BAD_REQUEST
            );
        }
        try {
            SkyITContact savedContact = contactService.saveContact(contactDTO);
            logger.info("Contact saved successfully: {}", savedContact);
            return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.CREATED.value(), "Contact Saved Successfully", true, savedContact), HttpStatus.CREATED
            );
        } catch (Exception e) {
            logger.error("Error saving contact: {}", e.getMessage(), e);
            return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving contact", false), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
	
	
	@GetMapping("/get-contact")
	public ResponseEntity<ApiResponse<?>> getContactDetails() {
	    logger.info("Received request to fetch all contacts");
	    try {
	    	List<SkyITContact> contact = contactService.getContactDetails();
	        logger.info("Successfully fetched {} contacts", contact.size());
	        return new ResponseEntity<>(
	                new ApiResponse<>(HttpStatus.OK.value(), "Data Fetched Successfully", true, contact), HttpStatus.OK);
	    } catch (CustomException e) {
	        logger.error("Error fetching contacts: {}", e.getMessage(), e);
	        return new ResponseEntity<>(
	                new ApiResponse<>(e.getStatus().value(), e.getMessage(), false), e.getStatus());
	    }
	}
	 
	  
	@GetMapping("/get-hr-contact")
	public ResponseEntity<ApiResponse<?>> getHRContactDetails() {
	    logger.info("Received request to fetch HR contact details");
	    try {
	        HRContactDTO hrContactDTO = contactService.getHRContactDetails();
	        logger.info("Successfully fetched HR contact details: {}", hrContactDTO);
	        return new ResponseEntity<>(
	                new ApiResponse<>(HttpStatus.OK.value(), "HR Data Fetched Successfully", true, hrContactDTO), HttpStatus.OK);
	    } catch (CustomException e) {
	        logger.error("Error fetching HR contact details: {}", e.getMessage(), e);
	        return new ResponseEntity<>(
	                new ApiResponse<>(e.getStatus().value(), e.getMessage(), false), e.getStatus());
	    }
	}
	
	@GetMapping("/get-business-contact")
	public ResponseEntity<ApiResponse<?>> getBusinessContactDetails() {
	    logger.info("Received request to fetch business contact details");
	    try {
	        BusinessContactDTO businessContactDTO = contactService.getBusinessContactDetails();
	        logger.info("Successfully fetched business contact details: {}", businessContactDTO);
	        return new ResponseEntity<>(
	                new ApiResponse<>(HttpStatus.OK.value(), "Business Data Fetched Successfully", true, businessContactDTO), HttpStatus.OK);
	    } catch (CustomException e) {
	        logger.error("Error fetching business contact details: {}", e.getMessage(), e);
	        return new ResponseEntity<>(
	                new ApiResponse<>(e.getStatus().value(), e.getMessage(), false), e.getStatus());
	    }
	}
	
	@DeleteMapping("/delete-contact/{id}")
	public ResponseEntity<ApiResponse<?>> deleteContact(@PathVariable String id, HttpSession session) {
	    logger.info("Received request to delete contact with id: {}", id);
	    try {
	        SkyITContact deletedContact = contactService.deleteContact(id);
	        logger.info("Successfully deleted contact: {}", deletedContact);
	        return new ResponseEntity<>(
	                new ApiResponse<>(HttpStatus.OK.value(), "Contact Deleted Successfully", true, deletedContact), HttpStatus.OK);
	    } catch (CustomException e) {
	        logger.error("Error deleting contact with id {}: {}", id, e.getMessage(), e);
	        return new ResponseEntity<>(
	                new ApiResponse<>(e.getStatus().value(), e.getMessage(), false), e.getStatus());
	    }
	}
}