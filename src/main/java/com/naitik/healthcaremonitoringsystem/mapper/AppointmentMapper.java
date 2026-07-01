package com.naitik.healthcaremonitoringsystem.mapper;

import com.naitik.healthcaremonitoringsystem.dto.AppointmentDTO;
import com.naitik.healthcaremonitoringsystem.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .status(appointment.getStatus())
                .patientId(appointment.getPatient().getId())
                .doctorId(appointment.getDoctor().getId())
                .build();
    }
}