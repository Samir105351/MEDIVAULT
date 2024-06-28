package com.samir.medivault.service;

import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrescriptionDetailsService {
    PrescriptionResponse createPrescription(PrescriptionRequest prescriptionRequest);

    PrescriptionResponse updatePrescription(Long prescriptionId, PrescriptionRequest prescriptionRequest);

    PrescriptionResponse deletePrescription(Long prescriptionId);

    Page<PrescriptionResponse> getPaginatedPrescription(Pageable pageable);
}
