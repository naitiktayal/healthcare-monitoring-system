package com.naitik.healthcaremonitoringsystem.controller;

import com.naitik.healthcaremonitoringsystem.dto.AppointmentDTO;
import com.naitik.healthcaremonitoringsystem.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentDTO createAppointment(@Valid @RequestBody AppointmentDTO dto) {
        return appointmentService.createAppointment(dto);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public AppointmentDTO updateAppointment(
            @PathVariable Long id,
            @Valid @RequestBody AppointmentDTO dto) {

        return appointmentService.updateAppointment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}