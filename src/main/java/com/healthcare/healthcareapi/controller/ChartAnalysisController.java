package com.healthcare.healthcareapi.controller;

import com.healthcare.healthcareapi.entity.Disease;
import com.healthcare.healthcareapi.entity.ReportVariables;
import com.healthcare.healthcareapi.service.ChartAnalysisService;
import com.healthcare.healthcareapi.service.ReportService;
import com.healthcare.healthcareapi.util.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UrlProvider.CHART_ANALYSIS_SERVICE)
@CrossOrigin("*")
public class ChartAnalysisController {

    @Autowired
    private ChartAnalysisService chartAnalysisService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/getAllReportTypes")
    public ResponseEntity<List<String>> getAllReportTypes() {

        return chartAnalysisService.getAllReportTypes();

    }
    @GetMapping("/getAllPatientAnalysis")
    public ResponseEntity<List<ReportVariables>> getAllPatientAnalysis() {
        return ResponseEntity.ok(reportService.getAllPatientAnalysis());
    }


}
