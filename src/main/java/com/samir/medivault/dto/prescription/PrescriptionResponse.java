package com.samir.medivault.dto.prescription;

import com.samir.medivault.enums.Gender;
import com.samir.medivault.enums.Status;

import java.util.Date;

public record PrescriptionResponse(
        Date PrescriptionDate,
        String patientName,
        Long patientAge,
        Gender patientGender,
        String diagnosis,
        String medicine,
        Date nextVisitDate,
        Status status
) {
}
