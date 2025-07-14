package com.isa.platform.u202220659.monitoring.interfaces.rest.resources;

public record CreateSnapshotResource (String snapshotId,String productSerialNumber,Double temperature,Double energy,Integer leakage){
}
