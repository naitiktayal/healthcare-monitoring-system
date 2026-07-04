package com.naitik.healthcaremonitoringsystem.repository;

import com.naitik.healthcaremonitoringsystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);

    List<Appointment> findByPatientId(Long patientId);

    List<Appointment> findByAppointmentDateGreaterThanEqualOrderByAppointmentDateAsc(
            LocalDate date
    );

    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
}
