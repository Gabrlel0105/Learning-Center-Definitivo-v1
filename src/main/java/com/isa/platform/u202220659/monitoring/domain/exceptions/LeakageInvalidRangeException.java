package com.isa.platform.u202220659.monitoring.domain.exceptions;


//, leakage
//(Integer, Obligatorio, no vacío, requerido para products con Advance Monitoring Level,
//valores posibles 0 y 1).

public class LeakageInvalidRangeException extends RuntimeException{
    public LeakageInvalidRangeException(Integer leakage) {
        super("Leakage value " + leakage + " is invalid. It should be 0 or 1");
    }
}