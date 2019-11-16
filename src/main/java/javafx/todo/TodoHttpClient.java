package javafx.todo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoHttpClient {
    @GET("todos")
    CompletableFuture<List<TodoItem>> getAll();

    @GET("todos/{id}")
    CompletableFuture<TodoItem> get(@Path("id") long id);
}
