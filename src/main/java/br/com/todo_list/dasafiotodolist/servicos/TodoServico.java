package br.com.todo_list.dasafiotodolist.servicos;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.todo_list.dasafiotodolist.entidades.Todo;
import br.com.todo_list.dasafiotodolist.repositorio.TodoRepositorio;



@Service
public class TodoServico {

    private TodoRepositorio todoRepositorio;

    public TodoServico(TodoRepositorio todoRepositorio) {
        this.todoRepositorio = todoRepositorio;
    }

    public List<Todo> criar(Todo todo){
        todoRepositorio.save(todo);
        return listar();
    }

    public List<Todo> listar(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );
        return todoRepositorio.findAll(sort);
    }

    public List<Todo> atualizar(Todo todo){
        todoRepositorio.save(todo);
        return listar();
    }

    public List<Todo> apagar(Long id){
        todoRepositorio.deleteById(id);
        return listar();
    }
}
