package javafx.todo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

class TodoListController implements Initializable {

    @FXML
    private TableView<TodoItem> listView;

    @FXML
    private Button button;

    private final TodoHttpClient httpClient;

    TodoListController(TodoHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.getColumns().get(3).setCellFactory(callback -> new CheckBoxTableCell<>());
        Platform.runLater(() -> {
            final CompletableFuture<List<TodoItem>> todoItems = httpClient.getAll();
            listView.getItems()
                    .addAll(todoItems.join());
        });
    }
}