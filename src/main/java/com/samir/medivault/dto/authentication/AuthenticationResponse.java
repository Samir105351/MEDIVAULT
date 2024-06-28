package com.samir.medivault.dto.authentication;

import com.samir.medivault.enums.Status;

public record AuthenticationResponse(Status status, String token) {}
