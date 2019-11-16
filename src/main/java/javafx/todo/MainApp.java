package javafx.todo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        var todoList = loadFXML("todo_list");
        var todoHttpClient = retrofit.create(HttpClient.class);
        todoList.setController(new ListController(todoHttpClient));
        var scene = new Scene(todoList.load(), 800, 400);

        stage.setTitle("TodoApp | JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    static FXMLLoader loadFXML(String fxml) {
        return new FXMLLoader(MainApp.class.getResource(fxml + ".fxml"));
    }
}
