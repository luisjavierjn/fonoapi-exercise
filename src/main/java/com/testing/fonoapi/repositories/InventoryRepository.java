package com.testing.fonoapi.repositories;

import com.testing.fonoapi.domain.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
