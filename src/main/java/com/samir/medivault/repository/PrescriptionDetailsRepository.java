package com.samir.medivault.repository;

import com.samir.medivault.entity.PrescriptionDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PrescriptionDetailsRepository extends JpaRepository<PrescriptionDetails, Long> {
    @Query("SELECT p FROM PrescriptionDetails p WHERE MONTH(p.prescriptionDate) = MONTH(:currentDate) AND YEAR(p.prescriptionDate) = YEAR(:currentDate)")
    Page<PrescriptionDetails> findAllByCurrentMonth(@Param("currentDate") Date currentDate, Pageable pageable);
}
