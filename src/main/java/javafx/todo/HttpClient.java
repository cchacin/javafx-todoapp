package javafx.todo;

import retrofit2.Retrofit;
import retrofit2.http.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

interface HttpClient {

    @GET("todos")
    CompletableFuture<List<TodoItem>> getAll();

    @GET("todos/{id}")
    CompletableFuture<TodoItem> get(@Path("id") long id);

    @POST("todos")
    CompletableFuture<TodoItem> create(@Body TodoItem todoItem);

    @PUT("todos/{getId}")
    CompletableFuture<TodoItem> update(@Body TodoItem todoItem);

    @DELETE("todos/{id}")
    CompletableFuture<Void> delete(@Path("id") long id);

    static HttpClient create() {
        var retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JsonbConverterFactory.create())
                .build();

        return retrofit.create(HttpClient.class);
    }
}
