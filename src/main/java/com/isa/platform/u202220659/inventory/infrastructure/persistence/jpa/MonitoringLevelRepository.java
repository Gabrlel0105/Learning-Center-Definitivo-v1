package com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa;


import com.isa.platform.u202220659.inventory.domain.model.entities.MonitoringLevel;
import com.isa.platform.u202220659.inventory.domain.model.valueobjects.MonitoringLevels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MonitoringLevelRepository extends JpaRepository<MonitoringLevel,Integer> {
    boolean existsByName(MonitoringLevels name);

}
