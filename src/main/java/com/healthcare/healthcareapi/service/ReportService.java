package com.healthcare.healthcareapi.service;

import com.healthcare.healthcareapi.dto.ReportDTO;
import com.healthcare.healthcareapi.entity.ReportVariables;
import com.healthcare.healthcareapi.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public ResponseEntity<ReportDTO> getHartRateReportValues(String variableName) {
        List<ReportVariables> valuesForCharts = reportRepository.getValuesForCharts(variableName);

        ReportDTO reportDTO = ReportDTO.builder().build();
        if (valuesForCharts != null) {
            List<String> dataListLabel = new ArrayList<>();
            List<Double> dataList = new ArrayList<>();
            valuesForCharts.forEach(value -> {
                dataListLabel.add(value.getGeneratedDate().toString());
                dataList.add(value.getValue());

                reportDTO.setLabelList(dataListLabel);
                reportDTO.setDataList(dataList);

            });
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportDTO);
    }


    public List<ReportVariables> getAllPatientAnalysis() {
        return reportRepository.findAll();
    }
}
