package com.healthcare.healthcareapi.repository;

import com.healthcare.healthcareapi.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {


}
