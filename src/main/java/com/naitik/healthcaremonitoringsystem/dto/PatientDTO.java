package com.naitik.healthcaremonitoringsystem.dto;

import jakarta.validation.constraints.*;

public class PatientDTO {

    private Long id;

    @NotBlank(message = "Full Name is required")
    private String fullName;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age cannot exceed 120")
    private int age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Blood Group is required")
    private String bloodGroup;

    @NotBlank(message = "Address is required")
    private String address;

    public PatientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}