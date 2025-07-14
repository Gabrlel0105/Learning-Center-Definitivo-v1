package com.isa.platform.u202220659.monitoring.domain.services;
import com.isa.platform.u202220659.monitoring.domain.model.commands.CreateSnapshotCommand;
public interface SnapshotCommandService {
    Long handle(CreateSnapshotCommand createSnapshotCommand);
}
