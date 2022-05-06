package co.com.sofka.crud.services;


import co.com.sofka.crud.dtos.TodoListDTO;


public interface TodoListService {

    public Iterable<TodoListDTO> listAllTodo();

    public TodoListDTO getTodoList(Long id);

    public TodoListDTO saveTodoList(TodoListDTO todoListDTO);

    public void deleteTodoList(Long id);
}
