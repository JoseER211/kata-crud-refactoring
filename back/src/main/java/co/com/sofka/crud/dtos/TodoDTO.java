package co.com.sofka.crud.dtos;

import com.sun.istack.NotNull;

public class TodoDTO {

    private Long id;

    @NotNull
    private String name;

    private boolean completed;

    private Long catalogueId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getCatalogueId() {return catalogueId;}

    public void setCatalogueId(Long catalogueId) {this.catalogueId = catalogueId;}

}


