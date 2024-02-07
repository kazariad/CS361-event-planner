package dev.dkaz.eventplanner;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Task {
    public enum TaskPriority {LOW, MEDIUM, HIGH}

    private final SimpleObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

    private final SimpleStringProperty event = new SimpleStringProperty();

    private final SimpleStringProperty location = new SimpleStringProperty();

    private final SimpleObjectProperty<TaskPriority> priority = new SimpleObjectProperty<>();

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getEvent() {
        return event.get();
    }

    public SimpleStringProperty eventProperty() {
        return event;
    }

    public void setEvent(String event) {
        this.event.set(event);
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public TaskPriority getPriority() {
        return priority.get();
    }

    public SimpleObjectProperty<TaskPriority> priorityProperty() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority.set(priority);
    }
}
