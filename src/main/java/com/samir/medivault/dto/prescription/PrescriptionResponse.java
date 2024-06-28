package com.samir.medivault.dto.prescription;

import com.samir.medivault.enums.Status;

public record PrescriptionResponse(
        Status status,
        String messsage
) {
}
