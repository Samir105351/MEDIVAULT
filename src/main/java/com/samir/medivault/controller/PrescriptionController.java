package com.samir.medivault.controller;

import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;
import com.samir.medivault.service.PrescriptionDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {
    private final PrescriptionDetailsService prescriptionDetailsService;

@PostMapping("/create")
    ResponseEntity<PrescriptionResponse> createPrescription(@RequestBody PrescriptionRequest prescriptionRequest){
        return ResponseEntity.ok(prescriptionDetailsService.createPrescription(prescriptionRequest));
}

@PutMapping("/update/{prescriptionId}")
    ResponseEntity<PrescriptionResponse> updatePrescription(@PathVariable Long prescriptionId, @RequestBody PrescriptionRequest prescriptionRequest){
    return ResponseEntity.ok(prescriptionDetailsService.updatePrescription(prescriptionId, prescriptionRequest));
}

@DeleteMapping("/delete/{prescriptionId}")
    ResponseEntity<PrescriptionResponse> deletePrescription(@PathVariable Long prescriptionId){
    return ResponseEntity.ok(prescriptionDetailsService.deletePrescription(prescriptionId));
}

}
