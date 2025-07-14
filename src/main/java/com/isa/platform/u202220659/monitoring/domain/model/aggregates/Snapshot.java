package com.isa.platform.u202220659.monitoring.domain.model.aggregates;
import com.isa.platform.u202220659.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202220659.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Snapshot extends AuditableAbstractAggregateRoot<Snapshot> {


 //@NotBlank es solo para Strings. En Double o Integer no se usa.
    // Te lanza error en tiempo de ejecución si no lo corriges.

    @NotNull(message = "SnapshotId is required")       //Obligatorio
    @NotBlank(message = "Snapshot ID cannot be blank")  //snapshotId (String, Obligatorio, no vacío)
    @Getter
    @Column(unique = true)
    private String snapshotId;

    @NotNull(message = "SnapshotId is required")
    @NotBlank(message = "Snapshot  cannot be blank")
    @Getter
    private String productSerialNumber;

    @NotNull(message = "Temperature is required")
    @Getter
    private Double temperature;

    @NotNull(message = "Energy is required")
    @Getter
    private Double energy;

    @NotNull(message = "Leakage is required")
    @Getter
    private Integer leakage;

public Snapshot(){}
    public Snapshot(CreateSnapshotCommand command) {
this.snapshotId = command.snapshotId();
this.productSerialNumber = command.productSerialNumber();
this.temperature = command.temperature();
this.energy = command.energy();
    this.leakage=command.leakage();



}
}
