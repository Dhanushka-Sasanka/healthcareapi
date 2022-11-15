package com.healthcare.healthcareapi.service;


import com.healthcare.healthcareapi.entity.Patient;
import com.healthcare.healthcareapi.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public ResponseEntity<Patient> createPatient(Patient patient) {
        return new ResponseEntity<Patient>(patientRepository.save(patient), HttpStatus.OK);
    }

    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deletePatient(Long patientID) {
        return patientRepository.findById(patientID).map(patient1 -> {
            patientRepository.delete(patient1);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updatePatient(Patient patient, Long patientID) {
        if (!patientRepository.existsById(patientID)) {
            return ResponseEntity.notFound().build();
        }
        return patientRepository.findById(patientID).map(patient1 -> {
            BeanUtils.copyProperties(patient, patient1);
            patientRepository.save(patient1);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<List<Patient>> getAllPatientsByPIDOrName(String patientIDOrName) {
        if (patientRepository.findPatientsByPatientIDLikeOrPatientNameLike(patientIDOrName).isPresent()) {
            return new ResponseEntity<List<Patient>>(
                    patientRepository.findPatientsByPatientIDLikeOrPatientNameLike(patientIDOrName).get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }
}
