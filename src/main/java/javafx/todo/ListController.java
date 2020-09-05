package javafx.todo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.net.URL;
import java.util.ResourceBundle;

class ListController implements Initializable {

    @FXML
    TableView<TodoItem> listView;

    @FXML
    Button button;

    final HttpClient httpClient;

    ListController(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.listView.getColumns().get(3).setCellFactory(callback -> new CheckBoxTableCell<>());
        Platform.runLater(() -> this.listView.getItems().addAll(this.httpClient.getAll().join()));
    }

    static FXMLLoader createLoader(final HttpClient todoHttpClient) {
        final var todoList = new FXMLLoader(Main.class.getResource("todo_list.fxml"));

        todoList.setController(new ListController(todoHttpClient));

        return todoList;
    }
}