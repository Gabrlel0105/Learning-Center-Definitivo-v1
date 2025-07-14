package com.isa.platform.u202220659.monitoring.domain.exceptions;



//• No permite que se registre dos snapshots con el mismo valor de snapshotId.
public class SameSnapshotIdException extends RuntimeException{
    public SameSnapshotIdException(String snapshotId) {
        super("Snapshot with snapshotId " + snapshotId + " already exists");
    }
}