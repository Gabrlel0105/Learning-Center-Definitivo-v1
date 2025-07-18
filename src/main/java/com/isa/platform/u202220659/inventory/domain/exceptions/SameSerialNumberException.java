package com.isa.platform.u202220659.inventory.domain.exceptions;

public class SameSerialNumberException extends RuntimeException{
    public SameSerialNumberException(String serialNumber) {
        super("Product with serial number " + serialNumber + " already exists");
    }
}