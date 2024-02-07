package dev.dkaz.eventplanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateTaskController extends VBox {
    public CreateTaskController() {
        try {
            FXMLLoader loader = new FXMLLoader(CreateTaskController.class.getResource("create-task-view.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() {
        priorityChoiceBox.getItems().addAll(Task.TaskPriority.values());

        saveButton.setOnAction(event -> {
            Task task = new Task();
            task.setDate(datePicker.getValue());
            task.setEvent(eventTextArea.getText());
            task.setLocation(locationTextField.getText());
            task.setPriority(priorityChoiceBox.getValue());
            Main.mainController.addTask(task);
            stage.hide();
        });

        cancelButton.setOnAction(event -> stage.hide());


        stage = new Stage();
        stage.setScene(new Scene(this));
        stage.setTitle("Add New Task");
        stage.setResizable(false);
        stage.setOnHidden(event -> clearForm());
    }

    public void show() {
        stage.show();
    }

    private void clearForm() {
        datePicker.setValue(null);
        eventTextArea.clear();
        locationTextField.clear();
        priorityChoiceBox.setValue(null);
    }

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
