package com.isa.platform.u202220659.inventory.domain.model.commands;

public record CreateProductCommand (String brand,String model,String serialNumber, Integer monitoringLevelId){
}
