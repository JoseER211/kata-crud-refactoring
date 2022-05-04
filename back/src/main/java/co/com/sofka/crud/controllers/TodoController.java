package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Hace el llamado del dato y lo pasa a la interfaz
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping(value = "api/todo")
    public ResponseEntity<TodoDTO> saveTodo(@RequestBody TodoDTO todoDTO) {
        return new ResponseEntity<>(todoService.createTodo(todoDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "api/todos")
    public List<TodoDTO> listTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping(value = "api/{id}/todo")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));

    }

    @PutMapping(value = "api/todo")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("api/{id}/todo")
    public ResponseEntity<String> deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Tarea eliminada con éxito", HttpStatus.OK);
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