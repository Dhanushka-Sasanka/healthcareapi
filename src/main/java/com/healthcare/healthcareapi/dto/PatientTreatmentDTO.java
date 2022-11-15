package com.healthcare.healthcareapi.dto;


import com.healthcare.healthcareapi.entity.Patient;
import com.healthcare.healthcareapi.entity.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientTreatmentDTO {

    private Long patientTreatmentDetailsID;
    private Patient patient;
    private Treatment treatment;
    private String attributeName;
    private String attributeValue;
    private String completeStatus;
}
