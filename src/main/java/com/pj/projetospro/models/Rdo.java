package com.pj.projetospro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_RDO")
public class Rdo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String nome;
    @Column
    private String funcao;
    @Column
    private String descricao;
    @Column
    private String dia;
    @Column
    private String mes;
    @Column
    private String projetoId;

}
