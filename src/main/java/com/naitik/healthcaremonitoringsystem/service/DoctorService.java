package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.DoctorDTO;
import java.util.List;
import org.springframework.data.domain.Page;

public interface DoctorService {

    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    List<DoctorDTO> getAllDoctors();

    DoctorDTO getDoctorById(Long id);

    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);

    void deleteDoctor(Long id);

    Page<DoctorDTO> getDoctors(
            int page,
            int size,
            String sortBy,
            String sortDir
    );

    Page<DoctorDTO> searchDoctorsByName(String name, int page, int size);

    Page<DoctorDTO> searchDoctorsBySpecialization(String specialization, int page, int size);
}