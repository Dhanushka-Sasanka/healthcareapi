package com.healthcare.healthcareapi.controller;

import com.healthcare.healthcareapi.dto.PatientTreatmentDTO;
import com.healthcare.healthcareapi.service.PatientTreatmentDetailService;
import com.healthcare.healthcareapi.util.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(UrlProvider.PATIENT_TREATMENT_SERVICE)
@CrossOrigin("http://localhost:4200/")
public class PatientTreatmentController {

    @Autowired
    private PatientTreatmentDetailService patientTreatmentService;


    @PostMapping("/")
    public ResponseEntity<?> createPatientTreatment(@RequestBody PatientTreatmentDTO PatientTreatmentDTO) {

        return patientTreatmentService.createPatientTreatment(PatientTreatmentDTO);

    }

    @GetMapping("/getPatientTreatmentDetails")
    public ResponseEntity<?> getAllPatientsTreatmentByPIDOrName(@RequestParam(value = "pid" ,required = false) Optional<String> pid,
                                                                @RequestParam(value = "patientName",required = false)
                                                                        Optional<String> patientName) {

        return patientTreatmentService.getAllPatientsTreatmentByPIDOrName(pid, patientName);

    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPatientsTreatmentByDefault() {

        return patientTreatmentService.getAllPatientsTreatmentByDefault();

    }

}
