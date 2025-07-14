package com.isa.platform.u202220659.inventory.interfaces.rest.transform;
import com.isa.platform.u202220659.inventory.interfaces.rest.resources.CreateProductResource;
import com.isa.platform.u202220659.inventory.domain.model.commands.CreateProductCommand;
public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource createProductResource) {
        return new CreateProductCommand(
                createProductResource.brand(),
                createProductResource.model(),
                createProductResource.serialNumber(),
                createProductResource.monitoringLevelId());
    }
}