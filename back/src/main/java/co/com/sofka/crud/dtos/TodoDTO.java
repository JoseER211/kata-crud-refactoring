package co.com.sofka.crud.dtos;


public class TodoDTO {

    private Long id;
    private String name;
    private Boolean completed;
    private Long todoListId;


    public TodoDTO() {
        super();
    }


    public TodoDTO(Long id, String name, Boolean completed, Long todoListId) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.todoListId = todoListId;
    }

    public Long getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Long todoListId) {
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
