package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.TodoListDTO;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping(value = "api/listAllTodo")
    public Iterable<TodoListDTO> listAllTodo() {
        return todoListService.listAllTodo();
    }

    @GetMapping(value = "api/{id}/getTodoList")
    public TodoListDTO getTodoList(@PathVariable("id") Long id) {
        return todoListService.getTodoList(id);
    }

    @PostMapping(value = "api/saveTodoList")
    public TodoListDTO saveTodoList(@RequestBody TodoListDTO todoListDTO) {
        return todoListService.saveTodoList(todoListDTO);
    }

    @DeleteMapping(value = "api/{id}/deleteTodoList")
    public void deleteTodoList(@PathVariable("id") Long id) {
        todoListService.deleteTodoList(id);
    }
}

