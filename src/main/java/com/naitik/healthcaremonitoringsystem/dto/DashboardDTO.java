package com.naitik.healthcaremonitoringsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {

    private long totalPatients;
    private long totalDoctors;
    private long totalAppointments;
}