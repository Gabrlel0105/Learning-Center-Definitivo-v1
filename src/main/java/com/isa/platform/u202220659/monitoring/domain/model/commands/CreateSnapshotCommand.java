package com.isa.platform.u202220659.monitoring.domain.model.commands;

public record CreateSnapshotCommand (String snapshotId,String productSerialNumber,Double temperature,Double energy,Integer leakage){
}
