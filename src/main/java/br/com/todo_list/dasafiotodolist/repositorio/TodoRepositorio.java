package br.com.todo_list.dasafiotodolist.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todo_list.dasafiotodolist.entidades.Todo;

public interface TodoRepositorio extends JpaRepository<Todo, Long> {
    
}
