package com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa;
import com.isa.platform.u202220659.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//• No permite que se registre dos products con el mismo valor de serialNumber.
Optional<Product> findBySerialNumber(String serialNumber);
}
