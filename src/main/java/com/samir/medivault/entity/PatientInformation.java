package com.samir.medivault.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "PATIENT_INFORMATION")
@Data
public class PatientInformation {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PATIENT_NAME", nullable = false)
    private String patientName;

    @Column(name = "PATIENT_AGE", nullable = false)
    private String patientAge;

    @Column(name = "PATIENT_GENDER", nullable = false)
    private String patientGender;

    @JoinColumn(name = "PATIENT_INFORMATION")
    @OneToMany
    private List<PrescriptionDetails> patients;
}
