package dev.dkaz.eventplanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpController extends VBox {
    public HelpController() {
        try {
            FXMLLoader loader = new FXMLLoader(HelpController.class.getResource("help-view.fxml"));
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
        stage.setTitle("Help");
        stage.setResizable(false);
        okButton.setOnAction(event -> stage.hide());
    }

    public void show() {
        stage.show();
    }

    private Stage stage;

    @FXML
    private Button okButton;
}
