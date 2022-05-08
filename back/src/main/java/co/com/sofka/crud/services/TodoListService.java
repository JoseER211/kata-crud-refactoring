package co.com.sofka.crud.services;


import co.com.sofka.crud.dtos.TodoListDTO;

/**
 * Representa los métodos que implementan el servicio del CRUD.
 *
 * @author Jose David Echavarria Ruiz.
 */
public interface TodoListService {
    /**
     * Obtiene todos los objetos.
     *
     * @return Lista con todos los objetos.
     */
    public Iterable<TodoListDTO> listAllTodo();

    /**
     * Obtiene el objeto por el id.
     *
     * @param id del objeto.
     * @return Objeto por el id.
     */
    public TodoListDTO getTodoList(Long id);

    /**
     * Guarda los objetos ingresados.
     *
     * @param todoListDTO objeto ingresado.
     * @return Objetos guardados.
     */
    public TodoListDTO saveTodoList(TodoListDTO todoListDTO);

    /**
     * Elimina un objeto por el id.
     *
     * @param id del objeto.
     */
    public void deleteTodoList(Long id);
}
