package com.samir.medivault.dto.register;

import com.samir.medivault.enums.Status;

public record RegisterResponse (
        Status status,
        String message
) {}
