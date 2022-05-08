package co.com.sofka.crud.services;


import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repositories.TodoListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoListServiceImplTest {

    @Autowired
    private TodoListRepository todoListRepository;

    @Test
    public void testSaveTodoList() {
        TodoList todoList = new TodoList();
        todoList.setId(1L);
        todoList.setName("Tarea 1");


        TodoList todoListRegister = todoListRepository.save(todoList);
        assertNotNull(todoListRegister);

    }


    @Test
    public void testGetTodoListById() {

        Long id = 1L;
        Optional<TodoList> todoList = todoListRepository.findById(id);

    }

    @Test
    public void testListTodoList() {
        List<TodoList> todoList = (List<TodoList>) todoListRepository.findAll();


    }


    @Test
    public void testDeleteTodoList() {
        TodoList todoList = new TodoList();
        todoList.setId(1L);
        todoList.setName("Tarea 1");

        todoListRepository.delete(todoList);
    }


}