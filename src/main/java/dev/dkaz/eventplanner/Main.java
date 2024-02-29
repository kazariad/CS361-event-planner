package dev.dkaz.eventplanner;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {
    public static final String VERSION = "v1.0";

    public static ExecutorService executorService;
    public static HttpClient httpClient;
    public static MotdService motdService;
    public static VersionService versionService;

    public static CreateTaskController createTaskController;
    public static HelpController helpController;
    public static MainController mainController;

    public static Image editIcon;
    public static Image deleteIcon;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        executorService = Executors.newCachedThreadPool();
        httpClient = HttpClient.newHttpClient();
        motdService = new MotdService(httpClient, URI.create("http://localhost:5000/motd"));
        versionService = new VersionService(httpClient, URI.create("http://localhost:5000/version"));

        editIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/pen.png").toString());
        deleteIcon = new Image(getClass().getResource("/dev/dkaz/eventplanner/delete.png").toString());

        createTaskController = new CreateTaskController();
        helpController = new HelpController();
        mainController = new MainController();
        mainController.show();
    }
}