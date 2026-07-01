
package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.DoctorDTO;
import com.naitik.healthcaremonitoringsystem.entity.Doctor;
import com.naitik.healthcaremonitoringsystem.exception.ResourceNotFoundException;
import com.naitik.healthcaremonitoringsystem.mapper.DoctorMapper;
import com.naitik.healthcaremonitoringsystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = DoctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return DoctorMapper.toDTO(savedDoctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(DoctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));

        return DoctorMapper.toDTO(doctor);
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));

        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setEmail(doctorDTO.getEmail());

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return DoctorMapper.toDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));

        doctorRepository.delete(doctor);
    }
}