package com.isa.platform.u202220659.monitoring.domain.exceptions;
//No es válido recibir requests de Snapshots que incluyan valores
// correspondientes a Advance
//Monitoring para Products cuyo valor de monitoringLevel es ESSENTIAL_MONITORING.
// Esto
//debe generar un response status de 400 y el mensaje “Snapshot Data not compatible with
//product current Monitoring Level

public class IncompatibleMonitoringLevelException extends RuntimeException{
    public IncompatibleMonitoringLevelException() {
        super("Snapshot Data not compatible with product current Monitoring Level");
    }
}