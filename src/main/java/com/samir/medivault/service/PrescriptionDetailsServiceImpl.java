package com.samir.medivault.service;

import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;
import com.samir.medivault.entity.PrescriptionDetails;
import com.samir.medivault.enums.Status;
import com.samir.medivault.repository.PrescriptionDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionDetailsServiceImpl implements PrescriptionDetailsService{
    private final PrescriptionDetailsRepository prescriptionDetailsRepository;
    private final UserService userService;
    @Override
    public PrescriptionResponse createPrescription(PrescriptionRequest prescriptionRequest) {
        PrescriptionDetails prescriptionDetails = PrescriptionDetails
                .builder()
                .prescriptionDate(prescriptionRequest.prescriptionDate())
                .patientName(prescriptionRequest.patientName())
                .patientAge(prescriptionRequest.patientAge())
                .patientGender(prescriptionRequest.patientGender())
                .diagnosis(prescriptionRequest.diagnosis())
                .medicine(prescriptionRequest.medicine())
                .nextVisitDate(prescriptionRequest.nextVisitDate())
                .user(userService.getCurrentUser())
                .build();

        PrescriptionDetails savedPrescriptionDetails = prescriptionDetailsRepository.save(prescriptionDetails);

        return new PrescriptionResponse(
                Status.SUCCESSFUL,
                "Prescription created successfully"
        );
    }
}
