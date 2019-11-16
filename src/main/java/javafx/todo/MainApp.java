package javafx.todo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var todoHttpClient = HttpClient.create();

        var todoList = ListController.createLoader(todoHttpClient);

        var scene = new Scene(todoList.load(), 800, 400);
        stage.setTitle("TodoApp | JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
