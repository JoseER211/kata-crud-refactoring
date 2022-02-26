package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Gestiona el acceso al dato

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list() {
        return repository.findAll();
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public Todo update(Todo todo) {
        try {
            isEqualTodo(todo);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.delete(get(id));
    }

    public Todo get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void isEqualTodo(Todo todo) {
        var todoUpdate = repository.findById(todo.getId()).orElseThrow();

        if (todoUpdate.getName().equals(todo.getName())) {
            throw new RuntimeException("Ya existe una tarea con ese nombre");
        }
    }

}
