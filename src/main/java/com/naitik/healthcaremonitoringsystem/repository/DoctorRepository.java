package com.naitik.healthcaremonitoringsystem.repository;

import com.naitik.healthcaremonitoringsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}