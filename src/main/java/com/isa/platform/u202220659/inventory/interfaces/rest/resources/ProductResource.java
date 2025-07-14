package com.isa.platform.u202220659.inventory.interfaces.rest.resources;

// agregar long id y lo de command
public record ProductResource(Long id,String brand,String model,String serialNumber, Integer monitoringLevelId) {
}
