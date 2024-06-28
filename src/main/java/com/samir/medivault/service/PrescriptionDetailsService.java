package com.samir.medivault.service;

import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;

public interface PrescriptionDetailsService {
    PrescriptionResponse createPrescription(PrescriptionRequest prescriptionRequest);
}
