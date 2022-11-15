package com.healthcare.healthcareapi.service;

import com.healthcare.healthcareapi.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartAnalysisService {

    @Autowired
    private ReportRepository reportRepository;


    public ResponseEntity<List<String>> getAllReportTypes() {
        return ResponseEntity.ok(reportRepository.getAllReportTypes());
    }




}
