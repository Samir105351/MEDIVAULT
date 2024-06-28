package com.samir.medivault.controller;

import com.samir.medivault.dto.prescription.PrescriptionDetailsResponse;
import com.samir.medivault.dto.prescription.PrescriptionRequest;
import com.samir.medivault.dto.prescription.PrescriptionResponse;
import com.samir.medivault.service.PrescriptionDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {
    private final PrescriptionDetailsService prescriptionDetailsService;

    @PostMapping("/create")
    ResponseEntity<PrescriptionResponse> createPrescription(@RequestBody PrescriptionRequest prescriptionRequest) {
        return ResponseEntity.ok(prescriptionDetailsService.createPrescription(prescriptionRequest));
    }

    @PutMapping("/update/{prescriptionId}")
    ResponseEntity<PrescriptionResponse> updatePrescription(@PathVariable Long prescriptionId, @RequestBody PrescriptionRequest prescriptionRequest) {
        return ResponseEntity.ok(prescriptionDetailsService.updatePrescription(prescriptionId, prescriptionRequest));
    }

    @DeleteMapping("/delete/{prescriptionId}")
    ResponseEntity<PrescriptionResponse> deletePrescription(@PathVariable Long prescriptionId) {
        return ResponseEntity.ok(prescriptionDetailsService.deletePrescription(prescriptionId));
    }

    @GetMapping("/get")
    ResponseEntity<Page<PrescriptionDetailsResponse>> getPrescriptionDetails(@RequestParam(required = false) Date fromDate,
                                                                             @RequestParam(required = false) Date toDate,
                                                                             @RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(prescriptionDetailsService.getPaginatedPrescription(pageable, fromDate, toDate));
    }

}
