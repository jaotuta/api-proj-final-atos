package com.pj.projetospro.dtos;

import com.pj.projetospro.models.Rdo;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ProjetoResponse {
    private UUID id;
    private String nome;
    private String empresa;
    private Date dataStart;

    public ProjetoResponse(UUID id, String nome, String empresa, Date dataStart) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;

        this.dataStart = dataStart;
    }
}
