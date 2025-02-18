package com.example.heartmonitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class HeartRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Integer heartRate;
    private LocalDateTime timestamp;

    // Getters and Setters
    public Long getId() {  // public
        return id;
    }

    public void setId(Long id) {  // public
        this.id = id;
    }

    public Long getPatientId() {  // public
        return patientId;
    }

    public void setPatientId(Long patientId) {  // public
        this.patientId = patientId;
    }

    public Integer getHeartRate() {  // public
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {  // public
        this.heartRate = heartRate;
    }

    public LocalDateTime getTimestamp() {  // public
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {  // public
        this.timestamp = timestamp;
    }
}