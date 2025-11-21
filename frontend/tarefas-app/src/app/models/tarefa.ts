export interface Tarefa {
  id?: number;
  titulo: string;
  descricao?: string;
  status: string;
  categoriaId: number;
  usuarioId: number;
  dataCriacao?: string;
  dataAtualizacao?: string;
}

export interface Categoria {
  id: number;
  nome: string;
  usuarioId: number;
}

export interface Usuario {
  id: number;
  nome: string;
  email: string;
}
