package com.healthcare.healthcareapi.controller;

import com.healthcare.healthcareapi.entity.Patient;
import com.healthcare.healthcareapi.service.PatientService;
import com.healthcare.healthcareapi.util.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlProvider.PATIENT_SERVICE)
@CrossOrigin("http://localhost:4200/")
public class PatientController {


    @Autowired
    private PatientService patientService;


    @PostMapping("/")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {

        return patientService.createPatient(patient);

    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAllPatients() {

        return patientService.getAllPatients();

    }

    @PutMapping("/{patientID}")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient, @PathVariable("patientID") Long patientID) {

        return patientService.updatePatient(patient, patientID);

    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<?> deletePatient(@PathVariable("patientID") Long patientID) {

        return patientService.deletePatient(patientID);

    }

    @GetMapping("/{patientNameOrID}")
    public ResponseEntity<List<Patient>> getAllPatientsByPIDOrName(@PathVariable("patientNameOrID") String patientNameOrID) {

        return patientService.getAllPatientsByPIDOrName(patientNameOrID);

    }
}
