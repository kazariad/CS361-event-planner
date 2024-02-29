package dev.dkaz.eventplanner;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {
    public static Image editIcon;
    public static Image deleteIcon;

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    public static MotdService motdService;

    public static CreateTaskController createTaskController;
    public static HelpController helpController;
    public static MainController mainController;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        editIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/pen.png").toString());
        deleteIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/delete.png").toString());

        motdService = new MotdService("http://localhost:5000/motd");

        createTaskController = new CreateTaskController();
        helpController = new HelpController();
        mainController = new MainController();
        mainController.show();
    }
}