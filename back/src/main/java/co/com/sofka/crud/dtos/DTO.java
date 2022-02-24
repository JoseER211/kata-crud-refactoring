package co.com.sofka.crud.dtos;

public class DTO {

    private Iterable<CatalogueDTO> catalogs;
    private Iterable<TodoDTO> todos;

    public Iterable<CatalogueDTO> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Iterable<CatalogueDTO> catalogs) {
        this.catalogs = catalogs;
    }

    public Iterable<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(Iterable<TodoDTO> todos) {
        this.todos = todos;
    }
}

