package com.naitik.healthcaremonitoringsystem.controller;

import com.naitik.healthcaremonitoringsystem.dto.DoctorDTO;
import com.naitik.healthcaremonitoringsystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorDTO createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        return doctorService.createDoctor(doctorDTO);
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/test")
    public String doctorTest() {
        return "Doctor Access Success";
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id,
                                  @Valid @RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctor(id, doctorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
    @GetMapping("/page")
    public Page<DoctorDTO> getDoctors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return doctorService.getDoctors(page, size);
    }

    @GetMapping("/search/name")
    public Page<DoctorDTO> searchByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return doctorService.searchDoctorsByName(name, page, size);
    }

    @GetMapping("/search/specialization")
    public Page<DoctorDTO> searchBySpecialization(
            @RequestParam String specialization,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return doctorService.searchDoctorsBySpecialization(specialization, page, size);
    }
}
