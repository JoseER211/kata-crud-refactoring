package co.com.sofka.crud.services;

import co.com.sofka.crud.dtos.ConvertDTO;

import co.com.sofka.crud.dtos.TodoListDTO;

import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repositories.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private ConvertDTO mapper;

    @Override
    public Iterable<TodoListDTO> listAllTodo() {
        ArrayList<TodoListDTO> todoListDTOS = new ArrayList<>();
        todoListRepository.findAll().forEach(todoList -> todoListDTOS.add(mapper.converTodoListDTO(todoList)));
        return todoListDTOS;
    }

    @Override
    public TodoListDTO getTodoList(Long id) {
        return mapper.converTodoListDTO(todoListRepository.findById(id).orElseThrow());
    }

    @Override
    public TodoListDTO saveTodoList(TodoListDTO todoListDTO) {
        TodoList todoList = mapper.convertTodoListEntity(todoListDTO);
        return mapper.converTodoListDTO(todoListRepository.save(todoList));
    }

    @Override
    public void deleteTodoList(Long id) {
        todoListRepository.delete(mapper.convertTodoListEntity(getTodoList(id)));
    }
}
