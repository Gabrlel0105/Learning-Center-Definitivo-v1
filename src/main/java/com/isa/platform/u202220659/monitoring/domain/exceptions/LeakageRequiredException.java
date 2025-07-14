package com.isa.platform.u202220659.monitoring.domain.exceptions;


//leakage
//(Integer, Obligatorio, no vacío, requerido para products con Advance Monitoring Level,
//valores posibles 0 y 1)
public class LeakageRequiredException extends RuntimeException{
    public LeakageRequiredException() {
        super("Leakage is required for products with Advance Monitoring level");
    }
}
