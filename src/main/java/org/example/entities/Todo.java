package org.example.entities;

public class Todo {
    private int id;
    private String title;
    private boolean completed;

    public Todo() {
        // Initialize default values
        this.title = "";
        this.completed = false;
        this.id = 0;
    }

    public Todo(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

