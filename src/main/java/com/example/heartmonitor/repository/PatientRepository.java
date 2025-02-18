package com.example.heartmonitor.repository;

import com.example.heartmonitor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
