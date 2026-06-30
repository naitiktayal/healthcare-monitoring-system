package com.naitik.healthcaremonitoringsystem.mapper;

import com.naitik.healthcaremonitoringsystem.dto.PatientDTO;
import com.naitik.healthcaremonitoringsystem.entity.Patient;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();

        dto.setId(patient.getId());
        dto.setFullName(patient.getFullName());
        dto.setAge(patient.getAge());
        dto.setGender(patient.getGender());
        dto.setPhoneNumber(patient.getPhoneNumber());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setAddress(patient.getAddress());

        return dto;
    }

    public static Patient toEntity(PatientDTO dto) {
        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setFullName(dto.getFullName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setBloodGroup(dto.getBloodGroup());
        patient.setAddress(dto.getAddress());

        return patient;
    }
}