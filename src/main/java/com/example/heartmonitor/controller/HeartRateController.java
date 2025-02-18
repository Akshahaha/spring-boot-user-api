package com.example.heartmonitor.controller;

import com.example.heartmonitor.model.HeartRate;
import com.example.heartmonitor.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heartrate")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @PostMapping
    public HeartRate recordHeartRate(@RequestBody HeartRate heartRate) {
        return heartRateService.recordHeartRate(heartRate);
    }

    @GetMapping("/{id}")
    public HeartRate getHeartRate(@PathVariable Long id) {
        return heartRateService.getHeartRate(id);
    }
}
