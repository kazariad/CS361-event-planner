module dev.dkaz.eventplanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.dkaz.eventplanner to javafx.fxml;
    exports dev.dkaz.eventplanner;
}