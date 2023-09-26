module appapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens database.models;
    opens database.dto;
    opens application.controllers;

    opens application to javafx.fxml;
    exports application;
}