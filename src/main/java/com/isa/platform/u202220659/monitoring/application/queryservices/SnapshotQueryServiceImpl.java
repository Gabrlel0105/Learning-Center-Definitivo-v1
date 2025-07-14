package com.isa.platform.u202220659.monitoring.application.queryservices;

import com.isa.platform.u202220659.inventory.infrastructure.persistence.jpa.ProductRepository;
import com.isa.platform.u202220659.monitoring.domain.exceptions.ProductWithIdNotFoundException;
import com.isa.platform.u202220659.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u202220659.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202220659.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.u202220659.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u202220659.monitoring.infrastructure.persistence.jpa.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnapshotQueryServiceImpl implements SnapshotQueryService {
  private final  SnapshotRepository snapshotRepository;
  private final ProductRepository productRepository;
  public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
      this.snapshotRepository = snapshotRepository;
      this.productRepository = productRepository;
  }
    @Override
    public Optional<Snapshot> handle(GetSnapshotByIdQuery query) {
        return snapshotRepository.findById(query.snapshotId());
    }

    @Override
    public List<Snapshot> handle(GetSnapshotsByProductIdQuery query) {
        var product = productRepository.findById(Math.toIntExact(query.productId()));
        if(product.isEmpty()) {
            throw new ProductWithIdNotFoundException(query.productId());
        }
        return snapshotRepository.findByProductSerialNumber(product.get().getSerialNumber());
    }
}