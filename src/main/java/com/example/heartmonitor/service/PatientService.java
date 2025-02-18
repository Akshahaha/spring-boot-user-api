package com.example.heartmonitor.service;

import com.example.heartmonitor.model.Patient;
import com.example.heartmonitor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
