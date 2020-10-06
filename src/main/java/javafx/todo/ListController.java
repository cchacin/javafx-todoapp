package javafx.todo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

class ListController implements Initializable {

    @FXML
    TableView<TodoItem> listView;

    @FXML
    Button button;

    final Supplier<List<TodoItem>> items;

    ListController(
            final Supplier<List<TodoItem>> items) {
        this.items = items;
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.listView.getColumns().get(3).setCellFactory(callback -> new CheckBoxTableCell<>());
        Platform.runLater(() -> this.listView.getItems().addAll(this.items.get()));
    }

    static FXMLLoader createLoader(
            final Supplier<List<TodoItem>> items) {
        final var todoList = new FXMLLoader(Main.class.getResource("todo_list.fxml"));

        todoList.setController(new ListController(items));

        return todoList;
    }
}