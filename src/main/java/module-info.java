module javafx.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires java.json.bind;
    requires okhttp3;
    requires transitive java.sql;

    opens javafx.todo to javafx.fxml, com.fasterxml.jackson.databind;
    exports javafx.todo;
}