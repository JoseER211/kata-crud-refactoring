package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.TodoDTO;

import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Hace el llamado de los métodos aplicados a la entidad y los pasa a la interfaz.
 *
 * @author Jose David Echavarria Ruiz.
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Obtiene todos los objetos.
     *
     * @return objetos.
     */
    @GetMapping(value = "api/todos")
    public Iterable<TodoDTO> listTodo() {
        return todoService.listTodo();
    }

    /**
     * Obtiene los objetos por el id.
     *
     * @param id del objeto.
     * @return objeto por el id.
     */
    @GetMapping(value = "api/{id}/todo")
    public TodoDTO getTodo(@PathVariable("id") Long id) {
        return todoService.getTodo(id);
    }

    /**
     * Guarda los objetos ingresados.
     *
     * @param todoDTO objeto ingresado.
     * @return Objeto ingresado.
     */
    @PostMapping(value = "api/todo")
    public TodoDTO saveTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.saveTodo(todoDTO);
    }

    /**
     * Actualiza los objetos ingresados.
     *
     * @param todoDTO objeto ingresado.
     * @return Objeto actualizado
     */
    @PutMapping(value = "api/todo")
    public TodoDTO updateTodo(@RequestBody TodoDTO todoDTO) {
        if (todoDTO.getId() != null) {
            return todoService.updateTodo(todoDTO);
        }
        throw new RuntimeException("No existe el id");
    }

    /**
     * Elimina el objeto por el id.
     *
     * @param id del objeto.
     */
    @DeleteMapping(value = "api/{id}/todo")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
    }


}