module dev.dkaz.todoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.dkaz.todoapp to javafx.fxml;
    exports dev.dkaz.todoapp;
}