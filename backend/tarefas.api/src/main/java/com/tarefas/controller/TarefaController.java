package com.tarefas.controller;

import com.tarefas.entity.Tarefa;
import com.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "http://localhost:4200")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;
    
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Tarefa>> listarTarefasPorUsuario(@PathVariable Long usuarioId) {
        List<Tarefa> tarefas = tarefaService.listarTarefasPorUsuario(usuarioId);
        return ResponseEntity.ok(tarefas);
    }
    
    @GetMapping("/usuario/{usuarioId}/status/{status}")
    public ResponseEntity<List<Tarefa>> listarTarefasPorStatus(
            @PathVariable Long usuarioId,
            @PathVariable String status) {
        List<Tarefa> tarefas = tarefaService.listarTarefasPorStatus(usuarioId, status);
        return ResponseEntity.ok(tarefas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> obterTarefa(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.obterTarefa(id);
        if (tarefa != null) {
            return ResponseEntity.ok(tarefa);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(
            @PathVariable Long id,
            @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = tarefaService.atualizarTarefa(id, tarefaAtualizada);
        if (tarefa != null) {
            return ResponseEntity.ok(tarefa);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
