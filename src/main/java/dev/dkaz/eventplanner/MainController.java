package dev.dkaz.eventplanner;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MainController extends VBox {
    public MainController() {
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("main-view.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() {
        stage = new Stage();
        stage.setScene(new Scene(this));
        stage.setTitle("Event Planner");
        stage.setResizable(false);

        createTaskButton.setOnAction(event -> Main.createTaskController.show());

        dateColumn.setCellValueFactory(param -> param.getValue().dateProperty());
        eventColumn.setCellValueFactory(param -> param.getValue().eventProperty());
        locationColumn.setCellValueFactory(param -> param.getValue().locationProperty());
        priorityColumn.setCellValueFactory(param -> param.getValue().priorityProperty());

        editColumn.setCellValueFactory(param -> {
            ImageView imageView = new ImageView(Main.editIcon);
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
            ImageView imageView = new ImageView(Main.deleteIcon);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setFitHeight(20);

            Button button = new Button();
            button.setGraphic(imageView);
            button.setBackground(null);
            button.setPadding(Insets.EMPTY);
            button.setTooltip(new Tooltip("Delete this task"));
            button.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this task?");
                alert.setHeaderText(null);
                alert.initModality(Modality.APPLICATION_MODAL);
                ((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
                if (alert.showAndWait().get() == ButtonType.OK) {
                    taskTable.getItems().remove(param.getValue());
                }
            });
            return new SimpleObjectProperty<>(button);
        });
    }

    public void show() {
        stage.show();
    }

    public void addTask(Task task) {
        taskTable.getItems().add(task);
    }

    private Stage stage;

    @FXML
    private Button createTaskButton;

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