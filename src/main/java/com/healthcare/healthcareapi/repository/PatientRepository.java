package com.healthcare.healthcareapi.repository;

import com.healthcare.healthcareapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    @Query(value = "SELECT * From patients p WHERE (p.patientID LIKE %:patientIDOrName% OR p.patient_name LIKE %:patientIDOrName%)" ,nativeQuery = true)
    Optional<List<Patient>> findPatientsByPatientIDLikeOrPatientNameLike(String patientIDOrName);
}
