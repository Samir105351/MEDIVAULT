package com.samir.medivault.repository;

import com.samir.medivault.entity.PatientInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientInformationRepository extends JpaRepository<PatientInformation, Long> {
}
