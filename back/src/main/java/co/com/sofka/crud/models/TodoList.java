package co.com.sofka.crud.models;


import javax.persistence.*;


/**
 * Representa una entidad TodoList.
 *
 * @author Jose David Echavarria Ruiz.
 */
@Entity
@Table(name = "todoList")
public class TodoList {
    /**
     * Propiedades de TodoList
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;


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
