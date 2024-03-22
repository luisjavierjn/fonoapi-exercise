package com.testing.fonoapi.repositories;

import com.testing.fonoapi.domain.entities.ReqType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementTypeRepository extends JpaRepository<ReqType, Long> {
    ReqType findByName(String nombre);
}
