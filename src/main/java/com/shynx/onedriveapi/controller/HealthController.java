package com.shynx.onedriveapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("message", "OneDrive Storage API is running");
        response.put("status", "OK");
        response.put("datetime", java.time.LocalDateTime.now().toString());

        return response;
    }

}
