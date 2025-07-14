package com.isa.platform.u202220659.inventory.domain.exceptions;

public class MonitoringLevelNotFoundException extends RuntimeException{
    public MonitoringLevelNotFoundException(Integer monitoringLevelId) {
        super("Monitoring level with id " + monitoringLevelId + " not found");
    }
}