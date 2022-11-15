package com.healthcare.healthcareapi.service;

import com.healthcare.healthcareapi.dto.PatientTreatmentDTO;
import com.healthcare.healthcareapi.entity.Patient;
import com.healthcare.healthcareapi.entity.PatientTreatmentDetails;
import com.healthcare.healthcareapi.repository.PatientRepository;
import com.healthcare.healthcareapi.repository.PatientTreatmentDetailRepository;
import com.healthcare.healthcareapi.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatientTreatmentDetailService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PatientTreatmentDetailRepository patientTreatmentDetailRepository;


    @Transactional
    public ResponseEntity<?> createPatientTreatment(PatientTreatmentDTO patient) {

        PatientTreatmentDetails ptd = new PatientTreatmentDetails();


        ptd.setPatientTreatmentDetailsID(0L);

        if (patientRepository.findById(patient.getPatient().getPatientID()).isPresent()) {
            ptd.setPatient(patient.getPatient());
        }

        if (treatmentRepository.findById(patient.getTreatment().getTreatmentID()).isPresent()) {
            ptd.setTreatment(patient.getTreatment());
        }

        ptd.setAttributeName(patient.getAttributeName());
        ptd.setAttributeValue(patient.getAttributeValue());
        ptd.setCompleteStatus(patient.getCompleteStatus());

        return new ResponseEntity<>(patientTreatmentDetailRepository.save(ptd), HttpStatus.OK);
    }

    public ResponseEntity<?> getAllPatientsTreatmentByPIDOrName(Optional<String> pid , Optional<String> patientNameOrID) {
        if (patientTreatmentDetailRepository.findPatientTreatmentDetailsByPatientIdOrPatientName(pid,patientNameOrID).isPresent()) {
            return new ResponseEntity<>(patientTreatmentDetailRepository.findPatientTreatmentDetailsByPatientIdOrPatientName(pid,patientNameOrID).get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> getAllPatientsTreatmentByDefault() {
        if (!patientTreatmentDetailRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(patientTreatmentDetailRepository.findAll(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }
}
