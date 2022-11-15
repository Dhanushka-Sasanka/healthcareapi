package com.healthcare.healthcareapi.controller;

import com.healthcare.healthcareapi.entity.Treatment;
import com.healthcare.healthcareapi.service.TreatmentService;
import com.healthcare.healthcareapi.util.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlProvider.TREATMENT_SERVICE)
@CrossOrigin("http://localhost:4200/")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;


    @PostMapping("/")
    public ResponseEntity<Treatment> createTreatment(@RequestBody Treatment treatment) {

        return treatmentService.createTreatment(treatment);

    }

    @GetMapping("/")
    public ResponseEntity<List<Treatment>> getAllTreatments() {

        return treatmentService.getAllTreatments();

    }

    @PutMapping("/{treatmentID}")
    public ResponseEntity<?> updateTreatment(@RequestBody Treatment treatment,
                                             @PathVariable("treatmentID") Long treatmentID) {

        return treatmentService.updateTreatment(treatment, treatmentID);

    }

    @DeleteMapping("/{treatmentID}")
    public ResponseEntity<?> deleteTreatment(@PathVariable("treatmentID") Long treatmentID) {

        return treatmentService.deleteTreatment(treatmentID);

    }
}
