package com.pj.projetospro.controllers;

import com.pj.projetospro.dtos.RdoRequest;
import com.pj.projetospro.models.Rdo;
import com.pj.projetospro.services.RdoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @PutMapping("/update")
    public ResponseEntity<Object> updateRdo(@RequestBody Rdo rdo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rdoService.updateRdo(rdo));
    }
    @GetMapping()
    public ResponseEntity<List<Rdo>> getRdos() {
        return ResponseEntity.status(HttpStatus.OK).body(rdoService.getRdos());
    }

    @GetMapping("/rdo-proj/{id}")
    public ResponseEntity<List<Rdo>> getByProjeto(@RequestParam String dia, @RequestParam String mes, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(rdoService.getRdosByProjeto(dia, mes, id));
    }

    @GetMapping("/rdodate")
    public ResponseEntity<List<Rdo>> getRdosBydate(@RequestParam String dia, @RequestParam String mes) {
        return ResponseEntity.status(HttpStatus.OK).body(rdoService.getRdosByDayAndMounth(dia, mes));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rdo>> getRdosById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(rdoService.getRdoByid(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Rdo>> removeRdosById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(rdoService.removeRdoByid(id));
    }
}
