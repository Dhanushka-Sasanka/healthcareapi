package com.healthcare.healthcareapi.repository;

import com.healthcare.healthcareapi.entity.ReportVariables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportVariables, Long> {

    @Query(value = "SELECT * FROM report_variables rv \n" +
            "WHERE  rv.variable_name = :variableName GROUP BY rv.generated_date", nativeQuery = true)
    List<ReportVariables> getValuesForCharts(@Param("variableName") String variableName);

    @Query(value = "SELECT distinct rv.variable_name from report_variables rv", nativeQuery = true)
    List<String> getAllReportTypes();

}
