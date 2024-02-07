package dev.dkaz.eventplanner;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addTaskButton.setOnAction(event -> Main.createTaskStage.show());

        dateColumn.setCellValueFactory(param -> param.getValue().dateProperty());
        eventColumn.setCellValueFactory(param -> param.getValue().eventProperty());
        locationColumn.setCellValueFactory(param -> param.getValue().locationProperty());
        priorityColumn.setCellValueFactory(param -> param.getValue().priorityProperty());

        editColumn.setCellValueFactory(param -> {
            Image image = new Image(getClass().getResource("/dev/dkaz/eventplanner/pen.png").toString());
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setFitHeight(20);

            Button button = new Button();
            button.setGraphic(imageView);
            button.setBackground(null);
            button.setPadding(Insets.EMPTY);
            button.setTooltip(new Tooltip("Edit this task"));
            button.setOnAction(event -> EditTaskController.create(param.getValue()));
            return new SimpleObjectProperty<>(button);
        });

        deleteColumn.setCellValueFactory(param -> {
            Image image = new Image(getClass().getResource("/dev/dkaz/eventplanner/delete.png").toString());
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setFitHeight(20);

            Button button = new Button();
            button.setGraphic(imageView);
            button.setBackground(null);
            button.setPadding(Insets.EMPTY);
            button.setTooltip(new Tooltip("Delete this task"));
            button.setOnAction(event -> taskTable.getItems().remove(param.getValue()));
            return new SimpleObjectProperty<>(button);
        });
    }

    public void addTask(Task task) {
        taskTable.getItems().add(task);
    }

    @FXML
    private Button addTaskButton;

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, LocalDate> dateColumn;

    @FXML
    private TableColumn<Task, String> eventColumn;

    @FXML
    private TableColumn<Task, String> locationColumn;

    @FXML
    private TableColumn<Task, Task.TaskPriority> priorityColumn;

    @FXML
    private TableColumn<Task, Button> editColumn;

    @FXML
    private TableColumn<Task, Button> deleteColumn;
}