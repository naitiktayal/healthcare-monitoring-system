package com.naitik.healthcaremonitoringsystem.controller;

import com.naitik.healthcaremonitoringsystem.dto.PatientDTO;
import com.naitik.healthcaremonitoringsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientDTO savePatient(@Valid @RequestBody PatientDTO dto) {
        return patientService.savePatient(dto);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/test")
    public String patientTest() {
        return "Patient Access Success";
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient Deleted Successfully";
    }

    // Pagination + Sorting
    @GetMapping("/page")
    public Page<PatientDTO> getPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        return patientService.getPatients(page, size, sortBy, sortDir);
    }


    // Search Patient By Name
    @GetMapping("/search/name")
    public Page<PatientDTO> searchByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return patientService.searchPatientsByName(name, page, size);
    }


    // Search Patient By Blood Group
    @GetMapping("/search/blood-group")
    public Page<PatientDTO> searchByBloodGroup(
            @RequestParam String bloodGroup,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return patientService.searchPatientsByBloodGroup(
                bloodGroup, page, size
        );
    }
}