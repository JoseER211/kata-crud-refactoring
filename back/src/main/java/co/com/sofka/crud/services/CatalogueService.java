package co.com.sofka.crud.services;

import co.com.sofka.crud.Connector;
import co.com.sofka.crud.dtos.CatalogueDTO;
import co.com.sofka.crud.dtos.CatalogueTodoDTO;
import co.com.sofka.crud.dtos.DTO;
import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.models.Catalogue;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.CatalogueRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogueService {

    @Autowired
    private CatalogueRepository repository;

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<CatalogueDTO> list(){

        Iterable<Catalogue> catalogs= repository.findAll();
        List<CatalogueDTO> catalogueDTOS = new ArrayList<>();

        for(Catalogue catalogue: catalogs){

            catalogueDTOS.add(Connector.makeCatalogueDTO(catalogue));
        }

        return catalogueDTOS;
    }
    public Catalogue save( CatalogueDTO catalogueDTO){
        Catalogue catalogue = Connector.makeCatalogue(catalogueDTO);
        return repository.save(catalogue);}

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Catalogue get(Long id){
        return repository.findById(id).orElseThrow();
    }

    public CatalogueDTO getDTO(Long id){
        Catalogue catalogue = get(id);
        return Connector.makeCatalogueDTO(catalogue);
    }

    public DTO showAll(){

        DTO DTO = new DTO();

        DTO.setCatalogs(list());
        Iterable<Todo> todos = todoRepository.findAll();
        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: todos){
            todosDTO.add(Connector.makeTodoDTO(todo));
        }
        DTO.setTodos(todosDTO);

        return DTO;
    }

    public Todo addTodo (CatalogueTodoDTO catalogueTodoDTO){
        Todo todo = Connector.makeTodo(catalogueTodoDTO);
        todo.setCatalogue(get(catalogueTodoDTO.getIdCatalogue()));
        return todoRepository.save(todo);
    }
}
