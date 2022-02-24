package co.com.sofka.crud.services;

import co.com.sofka.crud.Connector;
import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.CatalogueRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Gestiona el acceso al dato

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private CatalogueRepository catalogueRepository;

    public Iterable<TodoDTO> list(){

        Iterable<Todo> todos = repository.findAll();
        List<TodoDTO> todoDTOS = new ArrayList<>();
        for(Todo todo: todos){
            todoDTOS.add(Connector.makeTodoDTO(todo));
        }
        return todoDTOS;
    }

    public Todo save(TodoDTO todoDTO){
        Todo todo = Connector.makeTodo(todoDTO);
        todo.setCatalogue(catalogueRepository.findById(todoDTO.getCatalogueId()).orElseThrow());
        return repository.save(todo);}

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
        return repository.findById(id).orElseThrow();
    }

    public TodoDTO getDTO(Long id){
        Todo todo = get(id);
        return Connector.makeTodoDTO(todo);
    }

}
