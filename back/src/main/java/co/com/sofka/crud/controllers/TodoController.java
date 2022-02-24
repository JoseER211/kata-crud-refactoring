package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.services.TodoService;
import co.com.sofka.crud.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//Hace el llamado del dato y lo pasa a la interfaz
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDTO> list() {
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody TodoDTO todoDTO) {
        return service.save(todoDTO);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody TodoDTO todoDTO) {
        if (todoDTO.getId() != null) {
            return service.save(todoDTO);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoDTO get(@PathVariable("id") Long id) {
        return service.getDTO(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldError = "error";
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldError, errorMessage);
        });

        return errors;
    }
}
