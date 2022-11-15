package com.healthcare.healthcareapi.controller;

import com.healthcare.healthcareapi.entity.Disease;
import com.healthcare.healthcareapi.service.DiseaseService;
import com.healthcare.healthcareapi.util.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlProvider.DISEASE_SERVICE)
@CrossOrigin("http://localhost:4200/")
public class DiseaseController {


    @Autowired
    private DiseaseService diseaseService;


    @PostMapping("/")
    public ResponseEntity<Disease> createDisease(@RequestBody Disease disease) {

        return diseaseService.createDisease(disease);

    }

    @GetMapping("/")
    public ResponseEntity<List<Disease>> getAllDiseases() {

        return diseaseService.getAllDiseases();

    }

    @PutMapping("/{diseaseID}")
    public ResponseEntity<?> updateDisease(@RequestBody Disease disease, @PathVariable("diseaseID") Long diseaseID) {

        return diseaseService.updateDisease(disease, diseaseID);

    }

    @DeleteMapping("/{diseaseID}")
    public ResponseEntity<?> deleteDisease(@PathVariable("diseaseID") Long diseaseID) {

        return diseaseService.deleteDisease(diseaseID);

    }


}
