package com.samir.medivault.dto;

import com.samir.medivault.enums.Status;

public record AuthenticationResponse(Status status, String token) {}
