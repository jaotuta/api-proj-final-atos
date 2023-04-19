package com.pj.projetospro.services;

import com.pj.projetospro.dtos.RdoRequest;
import com.pj.projetospro.models.Rdo;
import com.pj.projetospro.repository.ProjetoRepository;
import com.pj.projetospro.repository.RdoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class RdoService {

    final RdoRepository rdoRepository;
    public Object novoRdo(RdoRequest rdoRequest) {
        Rdo rdo = new Rdo();
        BeanUtils.copyProperties(rdoRequest, rdo);
        return rdoRepository.save(rdo);

    }

    public List<Rdo> getRdos() {
        return rdoRepository.findAll();
    }
}
