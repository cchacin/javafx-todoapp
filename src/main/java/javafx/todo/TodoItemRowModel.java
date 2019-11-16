package javafx.todo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public final class TodoItemRowModel {
    private final SimpleLongProperty    id;
    private final SimpleLongProperty    userId;
    private final SimpleStringProperty  title;
    private final SimpleBooleanProperty completed;

    public TodoItemRowModel() {
        this(0L, 0L, "", false);
    }

    public TodoItemRowModel(TodoItem todoItem) {
        this(
                todoItem.getId(),
                todoItem.getUserId(),
                todoItem.getTitle(),
                todoItem.isCompleted()
        );
    }

    public TodoItemRowModel(
            long id,
            long userId,
            String title,
            boolean completed) {
        this(
                new SimpleLongProperty(id),
                new SimpleLongProperty(userId),
                new SimpleStringProperty(title),
                new SimpleBooleanProperty(completed)
        );
    }

    public TodoItemRowModel(
            SimpleLongProperty id,
            SimpleLongProperty userId,
            SimpleStringProperty title, SimpleBooleanProperty completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public long getUserId() {
        return userId.get();
    }

    public SimpleLongProperty userIdProperty() {
        return userId;
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public boolean isCompleted() {
        return completed.get();
    }

    public SimpleBooleanProperty completedProperty() {
        return completed;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public void setUserId(long userId) {
        this.userId.set(userId);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }
}
