package com.medicalservices.medical.repository;

import com.medicalservices.medical.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

;

public interface MedicalRepository extends JpaRepository<Medicine,String> {
}
