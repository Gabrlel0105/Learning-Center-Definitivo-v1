package com.isa.platform.u202220659.monitoring.interfaces.rest.transform;

import com.isa.platform.u202220659.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202220659.monitoring.interfaces.rest.resources.CreateSnapshotResource;

public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand toCommandFromResource (CreateSnapshotResource createSnapshotResource){
       return new CreateSnapshotCommand(
               createSnapshotResource.snapshotId(),
               createSnapshotResource.productSerialNumber(),
               createSnapshotResource.temperature(),
               createSnapshotResource.energy(),
               createSnapshotResource.leakage()
       );
    }
}
