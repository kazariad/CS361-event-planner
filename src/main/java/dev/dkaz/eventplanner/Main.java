package dev.dkaz.eventplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage mainStage;
    public static MainController mainController;
    public static Stage createTaskStage;
    public static CreateTaskController createTaskController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        mainStage.setScene(new Scene(mainLoader.load()));
        mainStage.setTitle("Event Planner");
        mainStage.setResizable(false);
        mainController = mainLoader.getController();

        createTaskStage = new Stage();
        FXMLLoader createTaskLoader = new FXMLLoader(Main.class.getResource("create-task-view.fxml"));
        createTaskStage.setScene(new Scene(createTaskLoader.load()));
        createTaskStage.setTitle("Add New Task");
        createTaskStage.setResizable(false);
        createTaskController = createTaskLoader.getController();

        mainStage.show();
    }
}