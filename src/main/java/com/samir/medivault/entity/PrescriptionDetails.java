package com.samir.medivault.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "PRESCRIPTION_DETAILS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDetails {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRESCRIPTION_DATE", nullable = false)
    private Date prescriptionDate;

    @Column(name = "DIAGNOSIS", nullable = false)
    private String diagnosis;

    @Column(name = "MEDICINE", nullable = false)
    private String medicine;

    @Column(name = "NEXT_VISIT_DATE")
    private Date nextVisitDate;

    @JoinColumn(name = "PATIENT_INFORMATION")
    @ManyToOne
    private PatientInformation patientInformation;
}
