package com.healthcare.healthcareapi.service;

import com.healthcare.healthcareapi.entity.Disease;
import com.healthcare.healthcareapi.repository.DiseaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    public ResponseEntity<Disease> createDisease(Disease disease) {
        return new ResponseEntity<Disease>(diseaseRepository.save(disease), HttpStatus.OK);
    }

    public ResponseEntity<List<Disease>> getAllDiseases() {
        return new ResponseEntity<>(diseaseRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteDisease(Long diseaseID) {
        return diseaseRepository.findById(diseaseID).map(disease1 -> {
            diseaseRepository.delete(disease1);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updateDisease(Disease disease, Long diseaseID) {
        if (!diseaseRepository.existsById(diseaseID)) {
            return ResponseEntity.notFound().build();
        }
        return diseaseRepository.findById(diseaseID).map(disease1 -> {
            BeanUtils.copyProperties(disease, disease1);
            diseaseRepository.save(disease1);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
