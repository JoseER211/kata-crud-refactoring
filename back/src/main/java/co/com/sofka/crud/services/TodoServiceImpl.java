package co.com.sofka.crud.services;

import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TodoDTO createTodo(TodoDTO todoDTO) {
        Todo todo = mapEntity(todoDTO);

        Todo newTodo = todoRepository.save(todo);

        return mapDTO(newTodo);
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        return todos.stream().map(this::mapDTO).collect(Collectors.toList());

    }

    @Override
    public TodoDTO getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        return mapDTO(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
       return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        todoRepository.deleteById(id);
    }

    //Convierte entidad a DTO
    private TodoDTO mapDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setId(todo.getId());
        todoDTO.setName(todo.getName());
        todoDTO.setCompleted(todo.isCompleted());

        return todoDTO;
    }

    //Convierte DTO a entidad
    private Todo mapEntity(TodoDTO todoDTO) {
        Todo todo = new Todo();

        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;

    }


}
