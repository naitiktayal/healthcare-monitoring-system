
package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.DoctorDTO;
import com.naitik.healthcaremonitoringsystem.entity.Doctor;
import com.naitik.healthcaremonitoringsystem.exception.ResourceNotFoundException;
import com.naitik.healthcaremonitoringsystem.mapper.DoctorMapper;
import com.naitik.healthcaremonitoringsystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;

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
    @Override
    public Page<DoctorDTO> getDoctors(
            int page,
            int size,
            String sortBy,
            String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return doctorRepository.findAll(pageable)
                .map(DoctorMapper::toDTO);
    }

    @Override
    public Page<DoctorDTO> searchDoctorsByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return doctorRepository
                .findByDoctorNameContainingIgnoreCase(name, pageable)
                .map(DoctorMapper::toDTO);
    }

    @Override
    public Page<DoctorDTO> searchDoctorsBySpecialization(String specialization, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return doctorRepository
                .findBySpecializationContainingIgnoreCase(specialization, pageable)
                .map(DoctorMapper::toDTO);
    }

}