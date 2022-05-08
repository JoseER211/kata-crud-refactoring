package co.com.sofka.crud.dtos;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Representa un covertidor de DTO a entidad y de entidad a DTO de las clases Todo y Todolist.
 *
 * @author Jose David Echavarria Ruiz.
 */
@Component
public class ConvertDTO {
    @Autowired
    private ModelMapper mapper;

    /**
     * Convierte la entidad Todo a DTO.
     *
     * @param todo entidad Todo.
     * @return DTO de la entidad.
     */
    public TodoDTO convertTodoDTO(Todo todo) {
        return mapper.map(todo, TodoDTO.class);
    }

    /**
     * Convierte el DTO de Todo a entidad.
     *
     * @param todoDTO DTO de Todo.
     * @return entidad del DTO.
     */
    public Todo convertTodoEntity(TodoDTO todoDTO) {
        return mapper.map(todoDTO, Todo.class);
    }

    /**
     * Convierte la entidad TodoList a DTO.
     *
     * @param todoList entidad TodoList.
     * @return DTO de la entidad.
     */
    public TodoListDTO converTodoListDTO(TodoList todoList) {
        return mapper.map(todoList, TodoListDTO.class);
    }

    /**
     * Convierte el DTO de TodoList a entidad.
     *
     * @param todoListDTO DTO de TodoList.
     * @return entidad del DTO.
     */
    public TodoList convertTodoListEntity(TodoListDTO todoListDTO) {
        return mapper.map(todoListDTO, TodoList.class);
    }
}
