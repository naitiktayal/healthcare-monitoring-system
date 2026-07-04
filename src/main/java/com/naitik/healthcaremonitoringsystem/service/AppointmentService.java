package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getAllAppointments();

    AppointmentDTO getAppointmentById(Long id);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);

    AppointmentDTO updateAppointmentStatus(Long id, String status);

    void deleteAppointment(Long id);

    List<AppointmentDTO> getAppointmentsByDoctorId(Long doctorId);

    List<AppointmentDTO> getAppointmentsByPatientId(Long patientId);

    List<AppointmentDTO> getUpcomingAppointments();

    List<AppointmentDTO> getTodayAppointments();
}