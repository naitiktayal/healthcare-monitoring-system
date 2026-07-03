package com.naitik.healthcaremonitoringsystem.mapper;

import com.naitik.healthcaremonitoringsystem.dto.AppointmentDTO;
import com.naitik.healthcaremonitoringsystem.entity.Appointment;
import com.naitik.healthcaremonitoringsystem.entity.Doctor;
import com.naitik.healthcaremonitoringsystem.entity.Patient;
public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appointment) {

        return AppointmentDTO.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .status(appointment.getStatus())
                .patientId(appointment.getPatient().getId())
                .doctorId(appointment.getDoctor().getId())
                .build();
    }

    public static Appointment toEntity(AppointmentDTO dto,
                                       Patient patient,
                                       Doctor doctor) {

        return Appointment.builder()
                .id(dto.getId())
                .appointmentDate(dto.getAppointmentDate())
                .appointmentTime(dto.getAppointmentTime())
                .status(dto.getStatus())
                .patient(patient)
                .doctor(doctor)
                .build();
    }
}