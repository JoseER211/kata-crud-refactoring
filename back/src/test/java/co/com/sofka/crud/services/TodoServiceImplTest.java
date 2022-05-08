package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.TodoRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoServiceImplTest {

    @Autowired
    TodoRepository todoRepository;


    @Test
    public void testSaveTodo() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setName("Tarea 1");
        todo.setCompleted(false);

        Todo todoRegister = todoRepository.save(todo);
        assertNotNull(todoRegister);

    }

    @Test
    public void testGetTodoById() {
        Long id = 1L;
        Optional<Todo> todo = todoRepository.findById(id);

    }

    @Test
    public void testListTodos() {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();

    }

    @Test
    public void testDeleteTodos() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setName("Tarea 1");
        todo.setCompleted(false);

        todoRepository.delete(todo);
    }

}