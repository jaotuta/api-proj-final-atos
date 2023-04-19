package com.pj.projetospro.controllers;

import com.pj.projetospro.dtos.RdoRequest;
import com.pj.projetospro.models.Rdo;
import com.pj.projetospro.services.RdoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rdo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RdoController {

    final RdoService rdoService;

    @PostMapping("/novo")
    public ResponseEntity<Object> novoRdo(@RequestBody RdoRequest rdoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rdoService.novoRdo(rdoRequest));
    }

    @GetMapping()
    public ResponseEntity<List<Rdo>> getRdos() {
        return ResponseEntity.status(HttpStatus.OK).body(rdoService.getRdos());
    }
}
