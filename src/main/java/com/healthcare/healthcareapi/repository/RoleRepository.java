package com.healthcare.healthcareapi.repository;



import com.healthcare.healthcareapi.entity.Role;
import com.healthcare.healthcareapi.entity.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer > {

    Optional<Role> findByRole(RoleType role);
}
