package co.com.sofka.crud.services;

import co.com.sofka.crud.dtos.ConvertDTO;
import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ConvertDTO mapper;


    @Override
    public Iterable<TodoDTO> listTodo() {
        ArrayList<TodoDTO> todoDTOS = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todoDTOS.add(mapper.convertTodoDTO(todo)));
        return todoDTOS;
    }

    @Override
    public TodoDTO getTodo(Long id) {
        return mapper.convertTodoDTO(todoRepository.findById(id).orElseThrow());
    }

    @Override
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = mapper.convertTodoEntity(todoDTO);
        return mapper.convertTodoDTO(todoRepository.save(todo));
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.delete(mapper.convertTodoEntity(getTodo(id)));
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(todoDTO.getId()).orElseThrow();
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        return mapper.convertTodoDTO(todoRepository.save(todo));
    }

}
