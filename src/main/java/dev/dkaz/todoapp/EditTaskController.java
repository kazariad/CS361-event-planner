package dev.dkaz.todoapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditTaskController extends VBox {
    public static EditTaskController create(Task task) {
        try {
            EditTaskController controller = new EditTaskController();
            controller.task = task;

            FXMLLoader loader = new FXMLLoader(EditTaskController.class.getResource("edit-task-view.fxml"));
            loader.setRoot(controller);
            loader.setController(controller);
            loader.load();

            controller.init();
            return controller;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private EditTaskController() {
    }

    private void init() {
        datePicker.setValue(task.getDate());
        eventTextArea.setText(task.getEvent());
        locationTextField.setText(task.getLocation());
        priorityChoiceBox.getItems().addAll(Task.TaskPriority.values());
        priorityChoiceBox.setValue(task.getPriority());

        saveButton.setOnAction(event -> {
            task.setDate(datePicker.getValue());
            task.setEvent(eventTextArea.getText());
            task.setLocation(locationTextField.getText());
            task.setPriority(priorityChoiceBox.getValue());
            stage.hide();
        });

        cancelButton.setOnAction(event -> stage.hide());

        stage = new Stage();
        stage.setScene(new Scene(this));
        stage.setTitle("Edit Task");
        stage.setResizable(false);
        stage.show();
    }

    private Task task;

    private Stage stage;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea eventTextArea;

    @FXML
    private TextField locationTextField;

    @FXML
    private ChoiceBox<Task.TaskPriority> priorityChoiceBox;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;
}
