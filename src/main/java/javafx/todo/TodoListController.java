package javafx.todo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class TodoListController implements Initializable {

    @FXML
    private TableView<TodoItemRowModel> listView;

    @FXML
    private Button button;

    private final TodoHttpClient httpClient;

    public TodoListController(TodoHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            final CompletableFuture<List<TodoItem>> todoItems = httpClient.getAll();
            listView.getItems().addAll(todoItems.join().stream().map(TodoItemRowModel::new).collect(Collectors.toList()));
        });
    }
}