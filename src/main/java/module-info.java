module dev.dkaz.eventplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens dev.dkaz.eventplanner to javafx.fxml;
    exports dev.dkaz.eventplanner;
}