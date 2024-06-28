package com.samir.medivault.dto.register;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {}
