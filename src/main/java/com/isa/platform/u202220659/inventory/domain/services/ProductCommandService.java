package com.isa.platform.u202220659.inventory.domain.services;
import com.isa.platform.u202220659.inventory.domain.model.commands.CreateProductCommand;
public interface ProductCommandService {
    Long handle(CreateProductCommand createProductCommand);

}
