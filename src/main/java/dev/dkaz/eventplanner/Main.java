package dev.dkaz.eventplanner;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static Image editIcon;
    public static Image deleteIcon;
    public static CreateTaskController createTaskController;
    public static MainController mainController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        editIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/pen.png").toString());
        deleteIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/delete.png").toString());
        createTaskController = new CreateTaskController();
        mainController = new MainController();
        mainController.show();
    }
}