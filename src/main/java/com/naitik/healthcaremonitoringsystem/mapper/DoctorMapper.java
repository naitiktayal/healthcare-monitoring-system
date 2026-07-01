package com.naitik.healthcaremonitoringsystem.mapper;

import com.naitik.healthcaremonitoringsystem.dto.DoctorDTO;
import com.naitik.healthcaremonitoringsystem.entity.Doctor;

public class DoctorMapper {

    public static DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();

        dto.setId(doctor.getId());
        dto.setDoctorName(doctor.getDoctorName());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setPhoneNumber(doctor.getPhoneNumber());
        dto.setEmail(doctor.getEmail());

        return dto;
    }

    public static Doctor toEntity(DoctorDTO dto) {
        Doctor doctor = new Doctor();

        doctor.setId(dto.getId());
        doctor.setDoctorName(dto.getDoctorName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setPhoneNumber(dto.getPhoneNumber());
        doctor.setEmail(dto.getEmail());

        return doctor;
    }
}