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
        return this.id;
    }

    @JsonbProperty("userId")
    public long getUserId() {
        return this.userId;
    }

    @JsonbProperty("title")
    public String getTitle() {
        return this.title;
    }

    @JsonbProperty("completed")
    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final TodoItem todoItem = (TodoItem) o;
        return this.getId() == todoItem.getId() &&
                this.getUserId() == todoItem.getUserId() &&
                this.isCompleted() == todoItem.isCompleted() &&
                this.getTitle().equals(todoItem.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUserId(), this.getTitle(), this.isCompleted());
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + this.id +
                ", userId=" + this.userId +
                ", title='" + this.title + '\'' +
                ", completed=" + this.completed +
                '}';
    }
}
