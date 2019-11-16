package javafx.todo;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
class MainAppTest implements WithAssertions {
    private MainApp mainApp = new MainApp();

    @Start
    private void start(Stage stage) throws Exception {
        mainApp.start(stage);
    }

    @Test
    void test(FxRobot robot) throws Exception {
        // Given
        final TableView<TodoItem> query = robot.lookup("#listView").query();

        // When
        final ObservableList<TodoItem> items = query.getItems();

        // Then
        assertThat(items).isNotEmpty();
    }
}
