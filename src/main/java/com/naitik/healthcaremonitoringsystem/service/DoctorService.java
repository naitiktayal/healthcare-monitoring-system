package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.DoctorDTO;
import java.util.List;

public interface DoctorService {

    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    List<DoctorDTO> getAllDoctors();

    DoctorDTO getDoctorById(Long id);

    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);

    void deleteDoctor(Long id);
}