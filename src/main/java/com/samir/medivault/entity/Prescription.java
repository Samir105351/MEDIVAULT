package com.samir.medivault.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PRESCRIPTION_DETAILS")
@Data
public class Prescription {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PRESCRIPTION_DATE", nullable = false)
    private Date prescriptionDate;

    @Column(name = "DIAGNOSIS", nullable = false)
    private String diagnosis;

    @Column(name = "MEDICINE", nullable = false)
    private String medicine;

    @Column(name = "NEXT_VISIT_DATE")
    private String nextVisitDate;

    @JoinColumn(name = "PATIENT_INFORMATION")
    @ManyToOne
    private Patient patient;
}
