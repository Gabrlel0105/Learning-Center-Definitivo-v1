package com.isa.platform.u202220659.monitoring.domain.exceptions;



//energy (Double,
//Obligatorio, no vacío, requerido para products con Advance Monitoring Level)


public class EnergyRequiredException extends RuntimeException{
    public EnergyRequiredException() {
        super("Energy is required for products with Advance Monitoring level");
    }
}