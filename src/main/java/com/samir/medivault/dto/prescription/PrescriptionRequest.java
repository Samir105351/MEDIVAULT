package com.samir.medivault.dto.prescription;

import com.samir.medivault.enums.Gender;

import java.util.Date;

public record PrescriptionRequest(
        Date prescriptionDate,
        String patientName,
        Long patientAge,
        Gender patientGender,
        String diagnosis,
        String medicine,
        Date nextVisitDate
) {
}
