package com.theskyit.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.theskyit.dto.CandidateDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.model.Candidate;
import com.theskyit.service.CandidateService;
import com.theskyit.service.EmailService;
import com.theskyit.service.ExcelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/candidate")
public class CandidateController {
	
	@Autowired
	private final CandidateService candidateService;
	
	@Autowired
	private final EmailService mailService;
	
	@Autowired
	private final ExcelService excelService;
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	public CandidateController(CandidateService candidateService, EmailService mailService, ExcelService excelService) {
		super();
		this.candidateService = candidateService;
		this.mailService = mailService;
		this.excelService = excelService;
	}

	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/show/candidate")
	public List<Candidate> getCandidate(){
		logger.info("Fetching all candidates");
		return candidateService.getAllCandidates();
	}
	
	@PostMapping("/form-submit")
	public ResponseEntity<ApiResponse> addCandidate(@ModelAttribute @Valid CandidateDTO candidateDTO, @RequestParam("resume") MultipartFile resume ) throws Exception{
		logger.info("Candidate form submission started");
	    try {
	        candidateService.addNewCandidate(candidateDTO, resume);
	        mailService.sendMailToAdmin(candidateDTO, resume);
	        logger.info("Candidate form submitted successfully");
	        return new ResponseEntity<>(new ApiResponse("Message Submitted successfully", true), HttpStatus.OK);
	    } catch (CustomException e) {
	    	logger.error("Error during form submission: {}", e.getMessage());
	        return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
	    }
	}
	
	@GetMapping("/download-excel")
	public ResponseEntity<?> downloadExcel() throws Exception{
		try {
	        byte[] excelContent = excelService.generateExcel();

	        if (excelContent == null || excelContent.length == 0) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT)
	                    .body("No data available to generate the Excel file.");
	        }

	        ByteArrayResource resource = new ByteArrayResource(excelContent);
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=job_candidates.xlsx")
	                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	                .contentLength(excelContent.length)
	                .body(resource);

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error generating Excel file: " + e.getMessage());
	    }
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		Map<String, Object> response = new LinkedHashMap<>();
//	    response.put("status", HttpStatus.BAD_REQUEST.value());
//	    response.put("error", "Validation Failed");
//	    
//	    List<String> errors = ex.getBindingResult()
//	                            .getFieldErrors()
//	                            .stream()
//	                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
//	                            .collect(Collectors.toList());
//	    response.put("messages", errors);
//
//	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
	
}
