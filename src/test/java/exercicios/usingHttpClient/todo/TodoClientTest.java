package exercicios.usingHttpClient.todo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoClientTest {
    TodoClient todoClient = new TodoClient();

    @Test
    @DisplayName("Should return a list with size 200")
    void findAll() throws IOException, InterruptedException {
        List<Todo> todos = todoClient.findAll();
        assertEquals(200, todos.size());
    }

    @Test
    void shouldReturnTodoGivenValidId() throws IOException, InterruptedException, TodoNotFoundException {
        Todo todo = todoClient.findById(1);
        assertEquals(1, todo.userId());
        assertEquals(1, todo.id());
        assertEquals("delectus aut autem", todo.title());
        assertFalse(todo.completed());
    }

    @Test
    void shouldThrowNotFoundExceptionGivenInvalidId(){
        TodoNotFoundException todoNotFoundException = assertThrows(TodoNotFoundException.class, () -> todoClient.findById(999));
        assertEquals("todo.Todo not found", todoNotFoundException.getMessage());
    }

    @Test
    void shouldCreateNewTodo() throws IOException, InterruptedException{
        Todo todo = new Todo(201, 1, "Learn Java",  false);
        HttpResponse<String> response = todoClient.create(todo);
        assertEquals(201, response.statusCode());
    }

    @Test
    void shouldUpdateExistingTodo() throws IOException, InterruptedException, TodoNotFoundException{
        Todo todo = new Todo(1, 1, "NEW TITLE",  true);
        HttpResponse<String> response = todoClient.update(todo);
        assertEquals(200, response.statusCode());
    }

    @Test
    void shouldDeleteExistingTodo() throws IOException, InterruptedException, TodoNotFoundException{
        Todo todo = todoClient.findById(1);
        HttpResponse<String> response = todoClient.delete(todo);
        assertEquals(200, response.statusCode());
    }
}