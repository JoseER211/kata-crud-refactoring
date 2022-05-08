package co.com.sofka.crud.dtos;

/**
 * Representa el DTO de TodoList.
 *
 * @author Jose David Echavarria Ruiz.
 */
public class TodoListDTO {
    /**
     * Propiedades de TodoListDTO.
     */
    private Long id;
    private String name;


    public TodoListDTO() {
        super();
    }

    public TodoListDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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


}

