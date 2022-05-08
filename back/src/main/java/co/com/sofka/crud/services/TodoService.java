package co.com.sofka.crud.services;

import co.com.sofka.crud.dtos.TodoDTO;

/**
 * Representa los métodos que implementan el servicio del CRUD.
 *
 * @author Jose David Echavarria Ruiz.
 */

public interface TodoService {

    /**
     * Obtiene todos los objetos.
     *
     * @return Lista con todos los objetos.
     */
    public Iterable<TodoDTO> listTodo();

    /**
     * Obtiene el objeto por el id.
     *
     * @param id del objeto.
     * @return Objeto por el id.
     */
    public TodoDTO getTodo(Long id);

    /**
     * Guarda los objetos ingresados.
     *
     * @param todoDTO objeto ingresado.
     * @return Objetos guardados.
     */
    public TodoDTO saveTodo(TodoDTO todoDTO);

    /**
     * Elimina un objeto por el id.
     *
     * @param id del objeto.
     */
    public void deleteTodo(Long id);

    /**
     * Actualiza el objeto ingresado.
     *
     * @param todoDTO objeto ingresado.
     * @return Objeto actualizado.
     */
    public TodoDTO updateTodo(TodoDTO todoDTO);


}
