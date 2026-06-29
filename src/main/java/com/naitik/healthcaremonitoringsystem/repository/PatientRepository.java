package com.naitik.healthcaremonitoringsystem.repository;

import com.naitik.healthcaremonitoringsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}