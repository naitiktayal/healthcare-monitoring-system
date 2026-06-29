package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.entity.Patient;
import com.naitik.healthcaremonitoringsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Save Patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get All Patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get Patient By Id
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Delete Patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}