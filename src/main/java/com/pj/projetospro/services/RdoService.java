package com.pj.projetospro.services;

import com.pj.projetospro.dtos.RdoRequest;
import com.pj.projetospro.models.Rdo;
import com.pj.projetospro.repository.RdoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<Rdo> getRdosByDayAndMounth(String dia, String mes) {
        return rdoRepository.findAllByDiaAndMes( dia,  mes);
    }

    public Optional<Rdo> getRdoByid(UUID id) {
        return rdoRepository.findById(id);
    }

    public List<Rdo> getRdosByProjeto(String dia, String mes, String projetoId) {
        return rdoRepository.findAllByDiaAndMesAndProjetoId(dia, mes, projetoId);
    }

    public Optional<Rdo> removeRdoByid(UUID id) {
        Optional<Rdo> rdo = Optional.of(new Rdo());
        rdo = rdoRepository.findById(id);
        rdoRepository.deleteById(id);
        return rdo;
    }
}
