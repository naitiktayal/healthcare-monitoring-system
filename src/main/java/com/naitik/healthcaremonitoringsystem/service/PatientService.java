package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.PatientDTO;
import com.naitik.healthcaremonitoringsystem.entity.Patient;
import com.naitik.healthcaremonitoringsystem.mapper.PatientMapper;
import com.naitik.healthcaremonitoringsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Save Patient
    public PatientDTO savePatient(PatientDTO dto) {
        Patient patient = PatientMapper.toEntity(dto);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(savedPatient);
    }

    // Get All Patients
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Patient By Id
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient != null ? PatientMapper.toDTO(patient) : null;
    }

    // Delete Patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}