package com.samir.medivault.controller;

import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;
import com.samir.medivault.service.PrescriptionDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {
    private final PrescriptionDetailsService prescriptionDetailsService;

@PostMapping("/create")
    ResponseEntity<PrescriptionResponse> createPrescription(@RequestBody PrescriptionRequest prescriptionRequest){
        return ResponseEntity.ok(prescriptionDetailsService.createPrescription(prescriptionRequest));
}

}
