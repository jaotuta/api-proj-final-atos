package com.pj.projetospro.repository;

import com.pj.projetospro.models.Rdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface RdoRepository extends JpaRepository<Rdo, UUID> {
    List<Rdo> findAllByDiaAndMes(String dia, String mes);
    List<Rdo> findAllByDiaAndMesAndProjetoId (String dia, String mes, String projetoId);
    List<Rdo> findAllByProjetoId (String projetoId);
}
