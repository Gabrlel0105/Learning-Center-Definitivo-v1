package com.isa.platform.u202220659.monitoring.infrastructure.persistence.jpa;
import com.isa.platform.u202220659.monitoring.domain.model.aggregates.Snapshot;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface SnapshotRepository extends JpaRepository<Snapshot,Long> {
   //• No permite que se registre dos snapshots con el mismo valor de snapshotId.
    boolean existsBySnapshotId(String snapshotId);
    List<Snapshot> findByProductSerialNumber(String serialNumber);
}
