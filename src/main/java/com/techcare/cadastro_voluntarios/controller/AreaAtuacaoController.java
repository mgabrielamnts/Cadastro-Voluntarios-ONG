package com.techcare.cadastro_voluntarios.controller;

import com.techcare.cadastro_voluntarios.model.AreaAtuacao;
import com.techcare.cadastro_voluntarios.service.AreaAtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaAtuacaoController {

    @Autowired
    private AreaAtuacaoService service;

    @GetMapping
    public ResponseEntity<List<AreaAtuacao>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaAtuacao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AreaAtuacao> salvar(@RequestBody AreaAtuacao area) {
        return ResponseEntity.ok(service.salvar(area));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
