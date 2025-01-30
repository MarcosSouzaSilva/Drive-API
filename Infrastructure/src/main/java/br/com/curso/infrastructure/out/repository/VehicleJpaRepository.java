package br.com.curso.infrastructure.out.repository;

import br.com.curso.infrastructure.domain.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long>{




}