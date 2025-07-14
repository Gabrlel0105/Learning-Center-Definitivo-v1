package com.isa.platform.u202220659.inventory.application.commandservices;


import com.isa.platform.u202220659.inventory.domain.exceptions.MonitoringLevelNotFoundException;
import com.isa.platform.u202220659.inventory.domain.exceptions.SameSerialNumberException;
import com.isa.platform.u202220659.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202220659.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202220659.inventory.domain.services.ProductCommandService;
import com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa.ProductRepository;
import com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa.MonitoringLevelRepository;
import org.springframework.stereotype.Service;
@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;
    private final MonitoringLevelRepository monitoringLevelRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository, MonitoringLevelRepository monitoringLevelRepository) {
        this.productRepository = productRepository;
        this.monitoringLevelRepository = monitoringLevelRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        var monitoringLevel = monitoringLevelRepository.findById(command.monitoringLevelId());
        if (monitoringLevel.isEmpty()) {
            throw new MonitoringLevelNotFoundException(command.monitoringLevelId());
        }

        var sameSerialNumber = productRepository.findBySerialNumber(command.serialNumber());
        if (sameSerialNumber.isPresent()) {
            throw new SameSerialNumberException(command.serialNumber());
        }
            Product product = new Product(command, monitoringLevel.get());
            try {
                productRepository.save(product);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error while saving product: " + e.getMessage());
            }
            return product.getId();
        }
    }
