package com.samir.medivault.dto;

import com.samir.medivault.enums.Gender;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Long patientAge,
        Gender patientGender
) {}
