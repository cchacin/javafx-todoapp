package javafx.todo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface HttpClient {

    @GET("todos")
    CompletableFuture<List<TodoItem>> getAll();

    @GET("todos/{id}")
    CompletableFuture<TodoItem> get(@Path("id") long id);

    @POST("todos")
    CompletableFuture<TodoItem> create(@Body TodoItem todoItem);

    @PUT("todos/{id}")
    CompletableFuture<TodoItem> update(@Body TodoItem todoItem);

    @DELETE("todos/{id}")
    CompletableFuture<Void> delete(@Path("id") long id);
    
    static HttpClient create(String url) {
        var retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(HttpClient.class);
    }
}
