package com.isa.platform.u202220659.monitoring.domain.exceptions;
//Cuando se responde una consulta de product por id, en el response, para el caso del valor
//de monitoringLevel, se debe retornar en el response su valor como String según
//corresponda, sea “ESSENTIAL_MONITORING” o “ADVANCE_MONITORING
public class ProductWithSerialNumberNotFoundException extends RuntimeException{
    public ProductWithSerialNumberNotFoundException(String serialNumber) {
        super("Product with serial number " + serialNumber + " not found");
    }
}