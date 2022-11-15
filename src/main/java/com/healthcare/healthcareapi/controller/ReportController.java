package com.healthcare.healthcareapi.controller;

import com.healthcare.healthcareapi.dto.ReportDTO;
import com.healthcare.healthcareapi.service.ReportService;
import com.healthcare.healthcareapi.util.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlProvider.REPORT_SERVICE)
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportService reportService;


    @GetMapping("/getReportValues")
    public ResponseEntity<ReportDTO> getReportValuesByVariableName(@RequestParam(value = "variableName") String variableName){

        return reportService.getHartRateReportValues(variableName);

    }
}
