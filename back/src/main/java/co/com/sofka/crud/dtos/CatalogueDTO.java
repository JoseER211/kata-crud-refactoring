package co.com.sofka.crud.dtos;

import com.sun.istack.NotNull;

public class CatalogueDTO {

    private Long id;

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
