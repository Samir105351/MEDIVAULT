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

        prescriptionDetailsRepository.save(prescriptionDetails);

        return new PrescriptionResponse(
                Status.SUCCESSFUL,
                "Prescription created successfully"
        );
    }

    @Override
    public PrescriptionResponse updatePrescription(Long prescriptionId, PrescriptionRequest prescriptionRequest) {
        PrescriptionDetails prevPrescriptionDetails = prescriptionDetailsRepository.findById(prescriptionId)
                .orElseThrow(()->new RuntimeException(STR."Prescription not found with id: \{prescriptionId}"));

        if(prevPrescriptionDetails.getUser() != userService.getCurrentUser()){
            throw new RuntimeException("You are trying to access a prescription belonging to a different user");
        }

        PrescriptionDetails prescriptionDetails = PrescriptionDetails
                .builder()
                .id(prevPrescriptionDetails.getId())
                .prescriptionDate(prescriptionRequest.prescriptionDate())
                .patientName(prescriptionRequest.patientName())
                .patientAge(prescriptionRequest.patientAge())
                .patientGender(prescriptionRequest.patientGender())
                .diagnosis(prescriptionRequest.diagnosis())
                .medicine(prescriptionRequest.medicine())
                .nextVisitDate(prescriptionRequest.nextVisitDate())
                .user(prevPrescriptionDetails.getUser())
                .build();

        prescriptionDetailsRepository.save(prescriptionDetails);

        return new PrescriptionResponse(
                Status.SUCCESSFUL,
                "Prescription updated successfully");
    }

    @Override
    public PrescriptionResponse deletePrescription(Long prescriptionId) {
        PrescriptionDetails prevPrescriptionDetails = prescriptionDetailsRepository.findById(prescriptionId)
                .orElseThrow(()->new RuntimeException(STR."Prescription not found with id: \{prescriptionId}"));

        if(prevPrescriptionDetails.getUser() != userService.getCurrentUser()){
            throw new RuntimeException("You are trying to access a prescription belonging to a different user");
        }

        prescriptionDetailsRepository.deleteById(prescriptionId);

        return new PrescriptionResponse(
                Status.SUCCESSFUL,
                "Prescription deleted successfully");
    }
}
