package com.healthcare.healthcareapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_treatment_details")
public class PatientTreatmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientTreatmentDetailsID;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "patient_ID" , referencedColumnName = "patientID")
    private Patient patient;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "treatment_ID" , referencedColumnName = "treatmentID")
    private Treatment treatment;

    private String attributeName;

    private String attributeValue;

    private String completeStatus;


}
