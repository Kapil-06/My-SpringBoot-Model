package com.theskyit.service.impl;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.theskyit.model.Candidate;
import com.theskyit.repository.CandidateRepository;
import com.theskyit.service.ExcelService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExcelServiceImpl implements ExcelService {
	
	private final CandidateRepository candidateRepository;
	
	public ExcelServiceImpl(CandidateRepository candidateRepository) {
		super();
		this.candidateRepository = candidateRepository;
	}

	public byte[] generateExcel() throws IOException {
        List<Candidate> candidates = candidateRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook(); 
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Job Applications");

            String[] headers = {
                "Name", "Email", "Phone", "Role", "Qualification", 
                "Experience", "Place", "Submission Date", "Resume"
            };

            // Create Header Row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int rowNum = 1;

            // Fill Data Rows
            for (Candidate candidate : candidates) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(candidate.getName());
                row.createCell(1).setCellValue(candidate.getEmail());
                row.createCell(2).setCellValue(candidate.getPhone());
                row.createCell(3).setCellValue(candidate.getRole());
                row.createCell(4).setCellValue(candidate.getEducationalQualification());
                row.createCell(5).setCellValue(candidate.getExperience());
                row.createCell(6).setCellValue(candidate.getLocation());
                row.createCell(7).setCellValue(
                    candidate.getSubmissionDate() != null 
                    ? dateFormat.format(candidate.getSubmissionDate()) 
                    : "N/A"
                );
                row.createCell(8).setCellValue(candidate.getResume());
            }

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
	}
}
