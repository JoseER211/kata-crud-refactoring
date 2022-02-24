package co.com.sofka.crud;

import co.com.sofka.crud.dtos.CatalogueDTO;
import co.com.sofka.crud.dtos.CatalogueTodoDTO;
import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.models.Catalogue;
import co.com.sofka.crud.models.Todo;

public class Connector {

    public static TodoDTO makeTodoDTO (Todo todo){
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setId(todo.getId());
        todoDTO.setName(todo.getName());
        todoDTO.setCompleted(todo.isCompleted());
        todoDTO.setCatalogueId(todo.getCatalogue().getId());

        return todoDTO;
    }

    public static Todo makeTodo(CatalogueTodoDTO catalogueTodoDTO){
        Todo todo = new Todo();
        todo.setName(catalogueTodoDTO.getNameTodo());
        todo.setCompleted(catalogueTodoDTO.isCompleted());

        return todo;
    }

    public static Todo makeTodo(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;
    }

    public static Catalogue makeCatalogue(CatalogueDTO catalogueDTO){
        Catalogue catalogue = new Catalogue();
        catalogue.setId(catalogueDTO.getId());
        catalogue.setName(catalogueDTO.getName());

        return catalogue;
    }

    public static CatalogueDTO makeCatalogueDTO(Catalogue catalogue){

        CatalogueDTO catalogueDTO = new CatalogueDTO();
        catalogueDTO.setId(catalogue.getId());
        catalogueDTO.setName(catalogue.getName());

        return catalogueDTO;
    }

}
