import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TarefaService } from '../../services/tarefa.service';
import { Tarefa } from '../../models/tarefa';

@Component({
  selector: 'app-lista-tarefas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-tarefas.component.html',
  styleUrls: ['./lista-tarefas.component.css']
})
export class ListaTarefasComponent implements OnInit {
  tarefas: Tarefa[] = [];
  usuarioId = 1; // ID do usuário de teste
  filtro = 'todas';

  constructor(private tarefaService: TarefaService) { }

  ngOnInit(): void {
    this.carregarTarefas();
  }

  carregarTarefas(): void {
    if (this.filtro === 'todas') {
      this.tarefaService.listarTarefas(this.usuarioId).subscribe({
        next: (data) => {
          this.tarefas = data;
        },
        error: (erro) => {
          console.error('Erro ao carregar tarefas:', erro);
        }
      });
    } else {
      this.tarefaService.listarTarefasPorStatus(this.usuarioId, this.filtro).subscribe({
        next: (data) => {
          this.tarefas = data;
        },
        error: (erro) => {
          console.error('Erro ao carregar tarefas:', erro);
        }
      });
    }
  }

  deletarTarefa(id: number | undefined): void {
    if (id) {
      this.tarefaService.deletarTarefa(id).subscribe({
        next: () => {
          this.carregarTarefas();
        },
        error: (erro) => {
          console.error('Erro ao deletar tarefa:', erro);
        }
      });
    }
  }

  marcarConcluida(tarefa: Tarefa): void {
    tarefa.status = tarefa.status === 'pendente' ? 'concluida' : 'pendente';
    this.tarefaService.atualizarTarefa(tarefa.id || 0, tarefa).subscribe({
      next: () => {
        this.carregarTarefas();
      },
      error: (erro) => {
        console.error('Erro ao atualizar tarefa:', erro);
      }
    });
  }

  aplicarFiltro(status: string): void {
    this.filtro = status;
    this.carregarTarefas();
  }
}
