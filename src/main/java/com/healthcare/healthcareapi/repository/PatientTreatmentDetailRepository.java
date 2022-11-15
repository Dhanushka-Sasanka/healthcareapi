package com.healthcare.healthcareapi.repository;

import com.healthcare.healthcareapi.entity.PatientTreatmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientTreatmentDetailRepository extends JpaRepository<PatientTreatmentDetails, Long> {


    @Query(value = "SELECT *" +
            "FROM patient_treatment_details ptd ,patients p WHERE p.patientID = ptd.patient_ID AND ptd.patient_ID LIKE %:patientID% OR p.patient_name LIKE %:patientName% GROUP BY ptd.patient_treatment_detailsid", nativeQuery = true)
    Optional<List<PatientTreatmentDetails>> findPatientTreatmentDetailsByPatientIdOrPatientName(@Param("patientID") Optional<String> patientID, @Param("patientName") Optional<String> patientNameOrID);

}
