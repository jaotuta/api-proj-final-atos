package com.pj.projetospro.controllers;

import com.pj.projetospro.dtos.ProjetoRequest;
import com.pj.projetospro.dtos.ProjetoResponse;
import com.pj.projetospro.models.Projetos;
import com.pj.projetospro.services.ProjetosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProjetosController {

    final ProjetosServices projetosServices;

    @GetMapping()
    public ResponseEntity<Page<Projetos>> buscarTodos (@PageableDefault(page = 0, size = 20, sort = "dataStart", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(projetosServices.buscarTodos(pageable));
    }

    @GetMapping("/with-flag")
    public ResponseEntity<Page<Projetos>> buscarTodosComFlag (@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                                       @RequestParam(required = false) String flag) {
        //return ResponseEntity.status(HttpStatus.OK).body(projetosServices.buscarTodos(pageable, flag));
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projetos>> getProjById (@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(projetosServices.getProjetoById(id));
    }

    @PostMapping("/novo")
    public ResponseEntity<Projetos> novoProjeto (@RequestBody ProjetoRequest projetoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetosServices.novoProjeto(projetoRequest));
    }

    @DeleteMapping("/remove/{id}")
    public void removerProjeto(@PathVariable UUID id) {
        ResponseEntity.status(HttpStatus.OK).body(projetosServices.removeProjeto(id));
    }

}
