package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entities.Todo;

import java.util.ArrayList;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoController {
    private static List<Todo> todos = new ArrayList<>();
    private static int nextId = 1;

    @GET
    public List<Todo> getAllTodos() {
        return todos;
    }

    @GET
    @Path("/{id}")
    public Todo getTodoById(@PathParam("id") int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        throw new NotFoundException("Todo with id " + id + " not found");
    }

    @POST
    public Todo createTodo(Todo todo) {
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }

    @PUT
    @Path("/{id}")
    public Todo updateTodo(@PathParam("id") int id, Todo updatedTodo) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setTitle(updatedTodo.getTitle());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        throw new NotFoundException("Todo with id " + id + " not found");
    }

    @DELETE
    @Path("/{id}")
    public void deleteTodo(@PathParam("id") int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
