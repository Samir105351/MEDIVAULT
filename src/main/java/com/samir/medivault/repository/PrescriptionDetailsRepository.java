package com.samir.medivault.repository;

import com.samir.medivault.entity.PrescriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionDetailsRepository extends JpaRepository<PrescriptionDetails, Long> {
}
