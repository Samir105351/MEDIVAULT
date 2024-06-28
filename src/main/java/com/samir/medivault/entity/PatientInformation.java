package com.samir.medivault.entity;

import com.samir.medivault.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PATIENT_INFORMATION")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientInformation {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PATIENT_NAME", nullable = false)
    private String patientName;

    @Column(name = "PATIENT_AGE", nullable = false)
    private Long patientAge;

    @Column(name = "PATIENT_GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender patientGender;

    @JoinColumn(name = "PRESCRIPTION_DETAILS")
    @OneToMany
    private List<PrescriptionDetails> prescriptionDetails;
}
