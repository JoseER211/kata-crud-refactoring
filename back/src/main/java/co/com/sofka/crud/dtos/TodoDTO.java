package co.com.sofka.crud.dtos;


/**
 * Representa el DTO de la entidad Todo
 *
 * @author Jose David Echavarria Ruiz.
 */
public class TodoDTO {

    /**
     * Propiedades de TodoDTO.
     */
    private Long id;
    private String name;
    private Boolean completed;

    public TodoDTO() {
        super();
    }


    public TodoDTO(Long id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;

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

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
