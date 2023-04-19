package com.pj.projetospro.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PROJETOS")
public class Projetos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String nome;
    @Column
    private String empresa;
    @Column
    private String flag = "andamento";
    @Column
    private Date dataStart;

}
