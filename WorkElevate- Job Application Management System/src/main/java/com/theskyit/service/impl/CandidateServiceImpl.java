package com.theskyit.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.dao.CandidateDAO;
import com.theskyit.dto.CandidateDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.model.Candidate;
import com.theskyit.service.CandidateService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Service
public class CandidateServiceImpl implements CandidateService {
    
    @Autowired
    private CandidateDAO candidateDAO;
    
   
    private final ModelMapper mapper = new ModelMapper();
    
    private static final Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

    public List<Candidate> getAllActiveCandidates() {
        logger.info("Fetching all candidates");
        List<Candidate> candidates = candidateDAO.getCandidates();
        logger.info("Found {} candidates", candidates.size());
        return candidates;
    }
    
    @Transactional
    public void addNewCandidate(@Valid CandidateDTO candidateDTO, MultipartFile file) throws Exception {
        logger.info("Adding new candidate with email: {}", candidateDTO.getEmail());
        
        // Check if candidate already exists and is not deleted
        if (candidateDAO.existsByEmailAndJobRoleAndIsDelete(candidateDTO.getEmail(), candidateDTO.getRole(), false)) {
            throw new CustomException("You have already applied for this job. Please try another job.", HttpStatus.BAD_REQUEST);
        }
        if (file == null || file.isEmpty()) {
            throw new CustomException("Resume file is required.", HttpStatus.BAD_REQUEST);
        }
        if (!"application/pdf".equals(file.getContentType())) {
            throw new CustomException("Only PDF files are allowed.", HttpStatus.BAD_REQUEST);
        }
        if (file.getSize() > 2 * 1024 * 1024) { // 2 MB
            throw new CustomException("File size must be less than 2 MB.", HttpStatus.BAD_REQUEST);
        }

        Candidate candidate = mapper.map(candidateDTO, Candidate.class);
        candidate.setSubmissionDate(new Date());
        candidate.setResume(file.getOriginalFilename());
        candidate.setData(file.getBytes());
        
        candidateDAO.saveCandidate(candidate);
        logger.info("Candidate added successfully");
    }

//  
    
    @Override
    public void deleteCandidate(String id) {
    	logger.info("Attempting to soft delete candidate with ID: {}", id);
        Candidate candidate = candidateDAO.getCandidateById(id);
        if (candidate == null) {
            logger.error("Candidate with ID: {} not found", id);
            throw new CustomException("Candidate Not Found", HttpStatus.NOT_FOUND);
        }
        candidate.setDeleted(true); // Mark as deleted
        candidateDAO.saveCandidate(candidate); // Save updated candidate
        logger.info("Successfully soft deleted Candidate with ID: {}", id);
    }
    
    @Override
    public ResponseEntity<List<Candidate>> getCandidateByRole(String role) {
        List<Candidate> candidates = candidateDAO.findByRoleIgnoreCase(role);
        if (!candidates.isEmpty()) {
            return ResponseEntity.ok(candidates);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }
    
    @Override
    public Candidate getCandidateById(String candidateId) {
    	return candidateDAO.getCandidateById(candidateId);
    }
    
//    @Override
//    public List<Candidate> getCandidatesByRoleRegex(String role){
//    	return candidateDAO.findByRoleRegex(role); 
//    }
    
    @Override
    public List<Candidate> getCandidatesByFilters(String role, String experience, String state, List<String> ids) {
        Query query = new Query();
        query.addCriteria(Criteria.where("isDeleted").is(false));
        if (ids != null && !ids.isEmpty()) {
            List<ObjectId> objectIds = new ArrayList<>();
            for (String id : ids) {
                try {
                    objectIds.add(new ObjectId(id)); // String ID ko ObjectId me convert karo
                } catch (IllegalArgumentException e) {
                    logger.error("Invalid ObjectId: {}", id, e);
                }
            }
            if (!objectIds.isEmpty()) {
                query.addCriteria(Criteria.where("_id").in(objectIds)); // Sirf in IDs ke hisab se filter karo
            } else {
                return Collections.emptyList();
            }
        } else {
            if (role != null && !role.isEmpty()) {
                query.addCriteria(Criteria.where("role").regex(Pattern.compile(role, Pattern.CASE_INSENSITIVE)));
            }
            if (experience != null && !experience.isEmpty()) {
                query.addCriteria(Criteria.where("experience").regex(Pattern.compile(experience, Pattern.CASE_INSENSITIVE)));
            }
            if (state != null && !state.isEmpty()) {
                query.addCriteria(Criteria.where("state").regex(Pattern.compile(state, Pattern.CASE_INSENSITIVE)));
            }
        }
        logger.debug("Final Query: {}", query.toString());
        return candidateDAO.findByQuery(query);
    }
    
 
    @Override
    public void exportCandidatesToExcel(List<Candidate> candidates, HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=candidates_by_filters.xlsx");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Candidates");

        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Email");
        headerRow.createCell(3).setCellValue("Phone");
        headerRow.createCell(4).setCellValue("Role");
        headerRow.createCell(5).setCellValue("Educational-Qualification");
        headerRow.createCell(6).setCellValue("Experience");
        headerRow.createCell(7).setCellValue("City");
        headerRow.createCell(8).setCellValue("State");
        headerRow.createCell(9).setCellValue("SubmissionDate");
        headerRow.createCell(10).setCellValue("Resume File Name");
        headerRow.createCell(11).setCellValue("Resume Download Link");
        // Populate data rows
        int rowNum = 1;
        for (Candidate candidate : candidates) {
        	int sr=rowNum;
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(sr);
            row.createCell(1).setCellValue(candidate.getName());
            row.createCell(2).setCellValue(candidate.getEmail());
            row.createCell(3).setCellValue(candidate.getPhone());
            row.createCell(4).setCellValue(candidate.getRole());
            row.createCell(5).setCellValue(candidate.getEducationalQualification());
            row.createCell(6).setCellValue(candidate.getExperience());
            row.createCell(7).setCellValue(candidate.getCity());
            row.createCell(8).setCellValue(candidate.getState());

            Cell dateCell = row.createCell(9);
            dateCell.setCellValue(candidate.getSubmissionDate());
            dateCell.setCellStyle(dateCellStyle);

            row.createCell(10).setCellValue(candidate.getResume());

            Cell linkCell = row.createCell(11);
            String resumeLink = "http://localhost:8080/api/v1/admin/download/resume/" + candidate.getId();
            Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress(resumeLink);
            linkCell.setHyperlink(hyperlink);
            linkCell.setCellValue("Download Resume");
        }
        // Write workbook to response output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }
    
    @Override
    public void exportCandidatesById(Candidate candidates, HttpServletResponse response) {
    	 // Set response headers for Excel file download
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=candidates_by_filters.xlsx");
        // Create Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Candidates");

        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Email");
        headerRow.createCell(3).setCellValue("Phone");
        headerRow.createCell(4).setCellValue("Role");
        headerRow.createCell(5).setCellValue("Educational-Qualification");
        headerRow.createCell(6).setCellValue("Experience");
        headerRow.createCell(7).setCellValue("City");
        headerRow.createCell(8).setCellValue("State");
        headerRow.createCell(9).setCellValue("SubmissionDate");
        headerRow.createCell(10).setCellValue("Resume File Name");
        headerRow.createCell(11).setCellValue("Resume Download Link");
        // Populate data rows
        	int rowNum=1;
            Row row = sheet.createRow(rowNum);
            //row.createCell(0).setCellValue(candidate.getId());
            row.createCell(0).setCellValue(candidates.getName());
            row.createCell(1).setCellValue(candidates.getEmail());
            row.createCell(2).setCellValue(candidates.getPhone());
            row.createCell(3).setCellValue(candidates.getRole());
            row.createCell(4).setCellValue(candidates.getEducationalQualification());
            row.createCell(5).setCellValue(candidates.getExperience());
            row.createCell(6).setCellValue(candidates.getCity());
            row.createCell(7).setCellValue(candidates.getState());

            Cell dateCell = row.createCell(8);
            dateCell.setCellValue(candidates.getSubmissionDate());
            dateCell.setCellStyle(dateCellStyle);

            row.createCell(9).setCellValue(candidates.getResume());

            Cell linkCell = row.createCell(10);
            String resumeLink = "http://localhost:8080/api/v1/admin/download/resume/" + candidates.getId();
            Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress(resumeLink);
            linkCell.setHyperlink(hyperlink);
            linkCell.setCellValue("Download Resume");

        // Write workbook to response output stream
        try {
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @Override
    public ResponseEntity<?> downloadResume(String candidateId, HttpServletResponse response) throws Exception {
        Candidate candidate = candidateDAO.getCandidateById(candidateId);
        if (candidate != null && candidate.getData() != null) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=" + candidate.getResume());
            response.getOutputStream().write(candidate.getData());
            response.getOutputStream().flush();
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(new ApiResponse<>("Resume not found", false), HttpStatus.NOT_FOUND);
        }
    }
}



