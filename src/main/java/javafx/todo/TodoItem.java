package javafx.todo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class TodoItem {
    private final long    id;
    private final long    userId;
    private final String  title;
    private final boolean completed;

    @JsonCreator
    public TodoItem(
            @JsonProperty("id") final long id,
            @JsonProperty("userId") final long userId,
            @JsonProperty("title") final String title,
            @JsonProperty("completed") final boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("userId")
    public long getUserId() {
        return userId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("completed")
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TodoItem todoItem = (TodoItem) o;
        return getId() == todoItem.getId() &&
                getUserId() == todoItem.getUserId() &&
                isCompleted() == todoItem.isCompleted() &&
                getTitle().equals(todoItem.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getTitle(), isCompleted());
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
