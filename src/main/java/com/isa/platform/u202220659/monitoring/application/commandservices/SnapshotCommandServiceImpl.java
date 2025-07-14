package com.isa.platform.u202220659.monitoring.application.commandservices;

import com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa.ProductRepository;
import com.isa.platform.u202220659.monitoring.domain.exceptions.*;
import com.isa.platform.u202220659.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202220659.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202220659.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202220659.monitoring.infrastructure.persistence.jpa.SnapshotRepository;
import org.springframework.stereotype.Service;

@Service
public class SnapshotCommandServiceImpl implements SnapshotCommandService {
    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateSnapshotCommand command) {
        if (snapshotRepository.existsBySnapshotId(command.snapshotId())) {
            throw new SameSnapshotIdException(command.snapshotId());
        }
        //productSerialNumber (String, Obligatorio, no vacío)...
        var product = productRepository.findBySerialNumber(command.productSerialNumber());
        if(product.isEmpty()) { throw new ProductWithSerialNumberNotFoundException(command.productSerialNumber()); }

        //energy (Double, Obligatorio para products con Advance Monitoring Level...)
        //leakage (Integer, Obligatorio para products con Advance Monitoring
        // Level, valores posibles 0 y 1)
        if(product.get().getMonitoringLevel().getName().equals("ADVANCED_MONITORING")) {
            if(command.energy() == null) {
                throw new EnergyRequiredException();
            }
            if(command.leakage() == null) {
                throw new LeakageRequiredException();
            }
            if(command.leakage() != 0 && command.leakage() != 1) {
                throw new LeakageInvalidRangeException(command.leakage());
            }
        }

        else{
            if(command.energy() != null || command.leakage() != null){
                throw new IncompatibleMonitoringLevelException();
            }
        }
        Snapshot snapshot = new Snapshot(command);
        try {
            snapshotRepository.save(snapshot);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving snapshot: " + e.getMessage());
        }
        return snapshot.getId();
    }
}