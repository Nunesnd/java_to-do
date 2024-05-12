package br.com.todo_list.dasafiotodolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo_list.dasafiotodolist.entidades.Todo;
import br.com.todo_list.dasafiotodolist.servicos.TodoServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")

public class TodoController {

    private TodoServico todoServico;
    
    public TodoController(TodoServico todoServico) {
        this.todoServico = todoServico;
    }

    @PostMapping
    List<Todo> criar(@RequestBody @Valid Todo todo){
        return todoServico.criar(todo);
    }

    @GetMapping
    List<Todo> listar(){
        return todoServico.listar();
    }

    @PutMapping
    List<Todo> atualizar(@RequestBody Todo todo){
        return todoServico.criar(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> apagar(@PathVariable("id") Long id){
        return todoServico.apagar(id);
    }

}
