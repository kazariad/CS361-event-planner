package dev.dkaz.todoapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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