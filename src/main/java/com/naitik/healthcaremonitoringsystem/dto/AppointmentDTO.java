package com.naitik.healthcaremonitoringsystem.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {

    private Long id;

    private LocalDate appointmentDate;

    private String status;

    private Long patientId;

    private Long doctorId;
}