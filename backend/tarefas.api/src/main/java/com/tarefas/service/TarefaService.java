package com.tarefas.service;

import com.tarefas.entity.Tarefa;
import com.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;
    
    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setDataCriacao(LocalDateTime.now());
        tarefa.setDataAtualizacao(LocalDateTime.now());
        return tarefaRepository.save(tarefa);
    }
    
    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            Tarefa t = tarefa.get();
            t.setTitulo(tarefaAtualizada.getTitulo());
            t.setDescricao(tarefaAtualizada.getDescricao());
            t.setStatus(tarefaAtualizada.getStatus());
            t.setCategoria(tarefaAtualizada.getCategoria());
            t.setDataAtualizacao(LocalDateTime.now());
            return tarefaRepository.save(t);
        }
        return null;
    }
    
    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
    
    public Tarefa obterTarefa(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }
    
    public List<Tarefa> listarTarefasPorUsuario(Long usuarioId) {
        return tarefaRepository.findByUsuarioId(usuarioId);
    }
    
    public List<Tarefa> listarTarefasPorStatus(Long usuarioId, String status) {
        return tarefaRepository.findByUsuarioIdAndStatus(usuarioId, status);
    }
}
