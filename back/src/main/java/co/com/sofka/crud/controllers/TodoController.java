package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.TodoDTO;

import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//Hace el llamado del dato y lo pasa a la interfaz
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping(value = "api/todos")
    public Iterable<TodoDTO> listTodo() {
        return todoService.listTodo();
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoDTO getTodo(@PathVariable("id") Long id) {
        return todoService.getTodo(id);
    }

    @PostMapping(value = "api/todo")
    public TodoDTO saveTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.saveTodo(todoDTO);
    }

    @PutMapping(value = "api/todo")
    public TodoDTO updateTodo(@RequestBody TodoDTO todoDTO) {
        if (todoDTO.getId() != null) {
            return todoService.updateTodo(todoDTO);
        }
        throw new RuntimeException("No existe el id");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
    }

    /**@Autowired private TodoService service;

     @GetMapping(value = "api/todos")
     public Iterable<Todo> list() {
     return service.list();
     }

     @PostMapping(value = "api/todo")
     public Todo save(@RequestBody Todo todo) {
     return service.save(todo);
     }

     @PutMapping(value = "api/todo")
     public Todo update(@RequestBody Todo todo) {
     return service.update(todo);
     }

     @DeleteMapping(value = "api/{id}/todo")
     public void delete(@PathVariable("id") Long id) {
     service.delete(id);
     }

     @GetMapping(value = "api/{id}/todo")
     public Todo get(@PathVariable("id") Long id) {
     return service.get(id);
     }*/

}