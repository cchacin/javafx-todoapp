module javafx.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires jsonb.retrofit.converter;
    requires java.json.bind;
    requires okhttp3;
    requires transitive java.sql;

    opens javafx.todo to javafx.fxml, java.json.bind, jsonb.retrofit.converter;
    exports javafx.todo;
}