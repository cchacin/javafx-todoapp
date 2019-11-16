module javafx.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.jackson;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens javafx.todo to javafx.fxml, com.fasterxml.jackson.databind;
    exports javafx.todo;
}