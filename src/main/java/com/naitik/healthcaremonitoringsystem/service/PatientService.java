package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.PatientDTO;
import com.naitik.healthcaremonitoringsystem.entity.Patient;
import com.naitik.healthcaremonitoringsystem.mapper.PatientMapper;
import com.naitik.healthcaremonitoringsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naitik.healthcaremonitoringsystem.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

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

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found with ID: " + id));

        return PatientMapper.toDTO(patient);
    }
    // Delete Patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Get Patients with Pagination and Sorting
    public Page<PatientDTO> getPatients(
            int page,
            int size,
            String sortBy,
            String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return patientRepository.findAll(pageable)
                .map(PatientMapper::toDTO);
    }


    // Search Patients By Full Name
    public Page<PatientDTO> searchPatientsByName(
            String name,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return patientRepository
                .findByFullNameContainingIgnoreCase(name, pageable)
                .map(PatientMapper::toDTO);
    }


    // Search Patients By Blood Group
    public Page<PatientDTO> searchPatientsByBloodGroup(
            String bloodGroup,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return patientRepository
                .findByBloodGroupContainingIgnoreCase(bloodGroup, pageable)
                .map(PatientMapper::toDTO);
    }
}