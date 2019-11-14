module javafx.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires flatter;

    opens javafx.todo to javafx.fxml;
    exports javafx.todo;
}