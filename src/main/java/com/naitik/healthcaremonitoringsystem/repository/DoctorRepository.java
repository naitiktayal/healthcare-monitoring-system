package com.naitik.healthcaremonitoringsystem.repository;

import com.naitik.healthcaremonitoringsystem.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findByDoctorNameContainingIgnoreCase(String doctorName, Pageable pageable);

    Page<Doctor> findBySpecializationContainingIgnoreCase(String specialization, Pageable pageable);
}