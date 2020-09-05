package javafx.todo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(final String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        final var todoHttpClient = HttpClient.create();

        final var todoList = ListController.createLoader(todoHttpClient);

        final var scene = new Scene(todoList.load(), 800, 400);
        stage.setTitle("TodoApp | JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
