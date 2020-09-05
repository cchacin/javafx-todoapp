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

    ListController(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.getColumns().get(3).setCellFactory(callback -> new CheckBoxTableCell<>());
        Platform.runLater(() -> listView.getItems().addAll(httpClient.getAll().join()));
    }

    static FXMLLoader createLoader(HttpClient todoHttpClient) {
        var todoList = new FXMLLoader(Main.class.getResource("todo_list.fxml"));

        todoList.setController(new ListController(todoHttpClient));

        return todoList;
    }
}