package co.com.sofka.crud.models;

import javax.persistence.*;


@Entity
@Table(name = "todo")
public class Todo {

    // propiedades de la entidad

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private Boolean completed;

    private Long todoListId;

    public Long getTodolistId() {
        return todoListId;
    }

    public void setTodolistId(Long todoListId) {
        this.todoListId = todoListId;
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
