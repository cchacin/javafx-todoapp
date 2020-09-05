package javafx.todo;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.util.Objects;

public final class TodoItem {
    private final long id;
    private final long userId;
    private final String title;
    private final boolean completed;

    @JsonbCreator
    public TodoItem(
            @JsonbProperty("id") final long id,
            @JsonbProperty("userId") final long userId,
            @JsonbProperty("title") final String title,
            @JsonbProperty("completed") final boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    @JsonbProperty("id")
    public long getId() {
        return id;
    }

    @JsonbProperty("userId")
    public long getUserId() {
        return userId;
    }

    @JsonbProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonbProperty("completed")
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
