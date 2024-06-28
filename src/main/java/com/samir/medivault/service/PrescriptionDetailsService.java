package com.samir.medivault.service;

import com.samir.medivault.dto.prescription.PrescriptionDetailsResponse;
import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface PrescriptionDetailsService {
    PrescriptionResponse createPrescription(PrescriptionRequest prescriptionRequest);

    PrescriptionResponse updatePrescription(Long prescriptionId, PrescriptionRequest prescriptionRequest);

    PrescriptionResponse deletePrescription(Long prescriptionId);

    Page<PrescriptionDetailsResponse> getPaginatedPrescription(Pageable pageable, Date fromDate, Date toDate);
}
