package com.pj.projetospro.services;

import com.pj.projetospro.dtos.ProjetoRequest;
import com.pj.projetospro.dtos.ProjetoResponse;
import com.pj.projetospro.models.Projetos;
import com.pj.projetospro.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjetosServices {

    final ProjetoRepository projetoRepository;

    public Projetos novoProjeto (ProjetoRequest projetoRequest) {

        Projetos projeto = new Projetos();
        BeanUtils.copyProperties(projetoRequest, projeto);
        projetoRepository.save(projeto);
        return projeto;
    }

    public Page<Projetos> buscarTodos(Pageable pageable, String flag) {
        return projetoRepository.findAllByFlag(flag, pageable);
    }



    public String removeProjeto(UUID id) {
        projetoRepository.deleteById(id);
        return "Projeto removido";
    }


}
