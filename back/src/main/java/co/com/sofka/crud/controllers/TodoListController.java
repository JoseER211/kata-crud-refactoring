package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.TodoListDTO;

import co.com.sofka.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * Hace el llamado de los métodos aplicados a la entidad y los pasa a la interfaz.
 *
 * @author Jose David Echavarria Ruiz.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    /**
     * Obtiene todos los objetos.
     *
     * @return objetos.
     */
    @GetMapping(value = "api/listAllTodo")
    public Iterable<TodoListDTO> listAllTodo() {
        return todoListService.listAllTodo();
    }

    /**
     * Obtiene los objetos por el id.
     *
     * @param id del objeto.
     * @return objeto por el id.
     */
    @GetMapping(value = "api/{id}/getTodoList")
    public TodoListDTO getTodoList(@PathVariable("id") Long id) {
        return todoListService.getTodoList(id);
    }

    /**
     * Guarda los objetos ingresados.
     *
     * @param todoListDTO objeto ingresado.
     * @return Objeto ingresado.
     */
    @PostMapping(value = "api/saveTodoList")
    public TodoListDTO saveTodoList(@RequestBody TodoListDTO todoListDTO) {
        return todoListService.saveTodoList(todoListDTO);
    }

    /**
     * Elimina el objeto por el id.
     *
     * @param id del objeto.
     */
    @DeleteMapping(value = "api/{id}/deleteTodoList")
    public void deleteTodoList(@PathVariable("id") Long id) {
        todoListService.deleteTodoList(id);
    }
}

