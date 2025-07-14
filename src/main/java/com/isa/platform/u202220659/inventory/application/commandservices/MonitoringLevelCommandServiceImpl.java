package com.isa.platform.u202220659.inventory.application.commandservices;

import com.isa.platform.u202220659.inventory.domain.model.commands.PopulateMonitoringLevelsCommand;
import com.isa.platform.u202220659.inventory.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202220659.inventory.domain.model.valueobjects.MonitoringLevels;
import com.isa.platform.u202220659.inventory.domain.services.MonitoringLevelCommandService;
import com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa.MonitoringLevelRepository;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class MonitoringLevelCommandServiceImpl implements MonitoringLevelCommandService {

    private final MonitoringLevelRepository monitoringLevelRepository;
    public MonitoringLevelCommandServiceImpl(MonitoringLevelRepository  monitoringLevelRepository) {
        this.monitoringLevelRepository = monitoringLevelRepository;
    }
    @Override
    public void handle(PopulateMonitoringLevelsCommand populateMonitoringLevelsCommand){
        Arrays.stream(MonitoringLevels.values()).forEach(genereType ->{
            if(monitoringLevelRepository.existsByName(genereType))
                monitoringLevelRepository.save(new MonitoringLevel(genereType));
        });
    }

}
