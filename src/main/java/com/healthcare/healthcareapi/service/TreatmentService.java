package com.healthcare.healthcareapi.service;


import com.healthcare.healthcareapi.entity.Treatment;

import com.healthcare.healthcareapi.repository.TreatmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public ResponseEntity<Treatment> createTreatment(Treatment treatment) {
        return new ResponseEntity<Treatment>(treatmentRepository.save(treatment), HttpStatus.OK);
    }

    public ResponseEntity<List<Treatment>> getAllTreatments() {
        return new ResponseEntity<>(treatmentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteTreatment(Long treatmentID) {
        return treatmentRepository.findById(treatmentID).map(treatment1 -> {
            treatmentRepository.delete(treatment1);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updateTreatment(Treatment treatment, Long treatmentID) {
        if ( !treatmentRepository.existsById(treatmentID)) {
            return ResponseEntity.notFound().build();
        }
        return treatmentRepository.findById(treatmentID).map(treatment1 -> {
            BeanUtils.copyProperties(treatment, treatment1);
            treatmentRepository.save(treatment1);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
