package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.DashboardDTO;
import com.naitik.healthcaremonitoringsystem.repository.AppointmentRepository;
import com.naitik.healthcaremonitoringsystem.repository.DoctorRepository;
import com.naitik.healthcaremonitoringsystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    public DashboardServiceImpl(
            PatientRepository patientRepository,
            DoctorRepository doctorRepository,
            AppointmentRepository appointmentRepository) {

        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public DashboardDTO getDashboardStats() {

        long totalPatients = patientRepository.count();
        long totalDoctors = doctorRepository.count();
        long totalAppointments = appointmentRepository.count();

        return DashboardDTO.builder()
                .totalPatients(totalPatients)
                .totalDoctors(totalDoctors)
                .totalAppointments(totalAppointments)
                .build();
    }
}