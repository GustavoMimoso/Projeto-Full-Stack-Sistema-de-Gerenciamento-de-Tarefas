<div class="formulario-container">
  <h2>Nova Tarefa</h2>
  
  <form (ngSubmit)="criarTarefa()">
    <div class="form-group">
      <label for="titulo">Título:</label>
      <input 
        type="text" 
        id="titulo" 
        [(ngModel)]="novaTarefa.titulo"
        name="titulo"
        placeholder="Digite o título da tarefa"
        required
      />
    </div>

    <div class="form-group">
      <label for="descricao">Descrição:</label>
      <textarea 
        id="descricao" 
        [(ngModel)]="novaTarefa.descricao"
        name="descricao"
        placeholder="Digite a descrição (opcional)"
        rows="4"
      ></textarea>
    </div>

    <div class="form-group">
      <label for="categoria">Categoria:</label>
      <select 
        id="categoria"
        [(ngModel)]="novaTarefa.categoriaId"
        name="categoria"
      >
        <option value="1">Trabalho</option>
        <option value="2">Pessoal</option>
        <option value="3">Estudos</option>
      </select>
    </div>

    <button type="submit" class="btn-criar">
      Criar Tarefa
    </button>
  </form>
</div>
