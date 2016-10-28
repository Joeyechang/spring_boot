package com.tts.actuator;

import org.springframework.boot.actuate.health.Health;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
public class HealthMonitor  {
//    @Override
    public Health health() {
        int errorCode = 1; // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
}
