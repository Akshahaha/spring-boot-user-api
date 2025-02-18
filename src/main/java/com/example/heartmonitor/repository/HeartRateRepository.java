package com.example.heartmonitor.repository;

import com.example.heartmonitor.model.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
}
