package com.techcare.cadastro_voluntarios.controller;

import com.techcare.cadastro_voluntarios.dto.VoluntarioRequest;
import com.techcare.cadastro_voluntarios.dto.VoluntarioResponse;
import com.techcare.cadastro_voluntarios.dto.VoluntarioUpdateRequest;
import com.techcare.cadastro_voluntarios.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService service;

    @GetMapping
    public ResponseEntity<List<VoluntarioResponse>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<VoluntarioResponse> salvar(@Valid @RequestBody VoluntarioRequest req) {
        VoluntarioResponse criado = service.salvar(req);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(criado.getIdVoluntario())
                .toUri();
        return ResponseEntity.created(uri).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoluntarioResponse> atualizar(@PathVariable Integer id,
                                                        @RequestBody VoluntarioUpdateRequest req) {
        return ResponseEntity.ok(service.atualizar(id, req));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/reativar")
    public ResponseEntity<VoluntarioResponse> reativar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.reativar(id));
    }

}
