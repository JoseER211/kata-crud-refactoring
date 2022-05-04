package co.com.sofka.crud.models;

import javax.persistence.*;


@Entity
public class Todo {

    // propiedades de la entidad

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private Boolean completed;

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

    public Todo() {

    }

    public Todo(Long id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }


}
