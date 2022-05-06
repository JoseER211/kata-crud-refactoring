package co.com.sofka.crud.dtos;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertDTO {

    @Autowired
    private ModelMapper mapper;

    public TodoDTO convertTodoDTO(Todo todo) {
        return mapper.map(todo, TodoDTO.class);
    }

    public Todo convertTodoEntity(TodoDTO todoDTO) {
        return mapper.map(todoDTO, Todo.class);
    }

    public TodoListDTO converTodoListDTO(TodoList todoList) {
        return mapper.map(todoList, TodoListDTO.class);
    }

    public TodoList convertTodoListEntity(TodoListDTO todoListDTO) {
        return mapper.map(todoListDTO, TodoList.class);
    }
}
