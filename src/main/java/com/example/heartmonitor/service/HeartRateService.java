package com.example.heartmonitor.service;

import com.example.heartmonitor.model.HeartRate;
import com.example.heartmonitor.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartRateService {
    @Autowired
    private HeartRateRepository heartRateRepository;

    public HeartRate recordHeartRate(HeartRate heartRate) {
        return heartRateRepository.save(heartRate);
    }

    public HeartRate getHeartRate(Long id) {
        return heartRateRepository.findById(id).orElse(null);
    }
}
