package co.com.sofka.crud.services;

import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.dtos.TodoListDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;

import java.util.List;

public interface TodoListService {

    public Iterable<TodoListDTO> listAllTodo();

    public TodoListDTO getTodoList(Long id);

    public TodoListDTO saveTodoList(TodoListDTO todoListDTO);

    public void deleteTodoList(Long id);
}
