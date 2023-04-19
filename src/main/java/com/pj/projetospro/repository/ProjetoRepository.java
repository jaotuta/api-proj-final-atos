package com.pj.projetospro.repository;

import com.pj.projetospro.models.Projetos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProjetoRepository extends JpaRepository<Projetos, UUID> {
    Page<Projetos> findAllByFlag(String flag, Pageable pageable);
}
