package com.isa.platform.u202220659.monitoring.interfaces.rest.resources;

public record SnapshotResource (Long id, String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage){
}
