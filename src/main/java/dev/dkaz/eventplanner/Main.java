package dev.dkaz.eventplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Image editIcon;
    public static Image deleteIcon;

    public static Stage mainStage;
    public static MainController mainController;
    public static CreateTaskController createTaskController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        editIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/pen.png").toString());
        deleteIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/delete.png").toString());

        mainStage = stage;
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        mainStage.setScene(new Scene(mainLoader.load()));
        mainStage.setTitle("Event Planner");
        mainStage.setResizable(false);
        mainController = mainLoader.getController();

        createTaskController = new CreateTaskController();

        mainStage.show();
    }
}