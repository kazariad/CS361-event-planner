package dev.dkaz.todoapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTaskController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        priorityChoiceBox.getItems().addAll(Task.TaskPriority.values());

        saveButton.setOnAction(event -> {
            Task task = new Task();
            task.setDate(datePicker.getValue());
            task.setEvent(eventTextArea.getText());
            task.setLocation(locationTextField.getText());
            task.setPriority(priorityChoiceBox.getValue());
            Main.mainController.addTask(task);
            Main.createTaskStage.hide();
        });

        cancelButton.setOnAction(event -> Main.createTaskStage.hide());

        Main.createTaskStage.setOnHidden(event -> clearForm());
    }

    private void clearForm() {
        datePicker.setValue(null);
        eventTextArea.clear();
        locationTextField.clear();
        priorityChoiceBox.setValue(null);
    }

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
