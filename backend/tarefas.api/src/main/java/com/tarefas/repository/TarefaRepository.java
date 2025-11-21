package com.tarefas.repository;

import com.tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByUsuarioId(Long usuarioId);
    List<Tarefa> findByUsuarioIdAndStatus(Long usuarioId, String status);
    List<Tarefa> findByUsuarioIdAndCategoriaId(Long usuarioId, Long categoriaId);
}
