package com.healthcare.healthcareapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report_variables")
public class ReportVariables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;
    private String variableName;
    private Double value;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date generatedDate;

    private Long patientID;

}
