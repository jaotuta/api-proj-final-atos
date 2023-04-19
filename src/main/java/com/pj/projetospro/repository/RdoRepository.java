package com.pj.projetospro.repository;

import com.pj.projetospro.models.Rdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RdoRepository extends JpaRepository<Rdo, UUID> {
}
