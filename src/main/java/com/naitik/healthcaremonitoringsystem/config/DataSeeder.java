package com.naitik.healthcaremonitoringsystem.config;

import com.naitik.healthcaremonitoringsystem.entity.Doctor;
import com.naitik.healthcaremonitoringsystem.entity.Patient;
import com.naitik.healthcaremonitoringsystem.repository.DoctorRepository;
import com.naitik.healthcaremonitoringsystem.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    private final Random random = new Random();

    public DataSeeder(PatientRepository patientRepository,
                      DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) {

        seedPatients();
        seedDoctors();

        System.out.println("======================================");
        System.out.println("DATABASE SEEDING COMPLETED");
        System.out.println("Total Patients: " + patientRepository.count());
        System.out.println("Total Doctors: " + doctorRepository.count());
        System.out.println("======================================");
    }

    private void seedPatients() {

        long existingPatients = patientRepository.count();

        if (existingPatients >= 100) {
            System.out.println("Patients already available: " + existingPatients);
            return;
        }

        String[] firstNames = {
                "Aarav", "Vivaan", "Aditya", "Arjun", "Krishna",
                "Rohan", "Rahul", "Aman", "Nikhil", "Karan",
                "Ananya", "Priya", "Neha", "Pooja", "Ishita",
                "Kavya", "Riya", "Sneha", "Aditi", "Meera"
        };

        String[] lastNames = {
                "Sharma", "Verma", "Gupta", "Singh", "Kumar",
                "Agarwal", "Yadav", "Jain", "Mishra", "Tiwari"
        };

        String[] genders = {
                "Male", "Female"
        };

        String[] bloodGroups = {
                "A+", "A-", "B+", "B-",
                "AB+", "AB-", "O+", "O-"
        };

        String[] cities = {
                "Delhi", "Noida", "Ghaziabad", "Gurugram",
                "Meerut", "Lucknow", "Agra", "Jaipur",
                "Kanpur", "Dehradun"
        };

        for (long i = existingPatients; i < 100; i++) {

            Patient patient = new Patient();

            String fullName =
                    firstNames[random.nextInt(firstNames.length)]
                            + " "
                            + lastNames[random.nextInt(lastNames.length)];

            patient.setFullName(fullName);

            patient.setAge(
                    18 + random.nextInt(63)
            );

            patient.setGender(
                    genders[random.nextInt(genders.length)]
            );

            patient.setPhoneNumber(
                    "9" + String.format("%09d", i + 100000000)
            );

            patient.setBloodGroup(
                    bloodGroups[random.nextInt(bloodGroups.length)]
            );

            patient.setAddress(
                    cities[random.nextInt(cities.length)] + ", India"
            );

            patientRepository.save(patient);
        }

        System.out.println("100 Patients ready");
    }

    private void seedDoctors() {

        long existingDoctors = doctorRepository.count();

        if (existingDoctors >= 50) {
            System.out.println("Doctors already available: " + existingDoctors);
            return;
        }

        String[] doctorNames = {
                "Amit Sharma", "Rahul Verma", "Neha Gupta",
                "Priya Singh", "Rohit Kumar", "Anjali Jain",
                "Vikas Yadav", "Pooja Mishra", "Karan Mehta",
                "Sneha Agarwal", "Arjun Kapoor", "Meera Joshi",
                "Nikhil Tiwari", "Kavya Saxena", "Aman Bansal"
        };

        String[] specializations = {
                "Cardiologist",
                "Neurologist",
                "Dermatologist",
                "Orthopedic",
                "Pediatrician",
                "General Physician",
                "ENT Specialist",
                "Psychiatrist",
                "Radiologist",
                "Oncologist"
        };

        for (long i = existingDoctors; i < 50; i++) {

            Doctor doctor = new Doctor();

            String doctorName =
                    doctorNames[random.nextInt(doctorNames.length)];

            doctor.setDoctorName(
                    "Dr. " + doctorName
            );

            doctor.setSpecialization(
                    specializations[
                            random.nextInt(specializations.length)
                            ]
            );

            doctor.setPhoneNumber(
                    "8" + String.format("%09d", i + 200000000)
            );

            doctor.setEmail(
                    "doctor" + (i + 1) + "@healthcare.com"
            );

            doctorRepository.save(doctor);
        }

        System.out.println("50 Doctors ready");
    }
}