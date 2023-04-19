package com.pj.projetospro.dtos;

import lombok.Data;

import java.util.UUID;


@Data
public class RdoRequest {
    private String nome;
    private String funcao;
    private String descricao;
    private String dia;
    private String mes;

}
