module com.seu.sponsor_hunter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.seu.sponsor_hunter to javafx.fxml;
    exports com.seu.sponsor_hunter;

    opens com.seu.sponsor_hunter.controller to javafx.fxml;
    exports com.seu.sponsor_hunter.controller;

    opens com.seu.sponsor_hunter.model to javafx.fxml;
    exports com.seu.sponsor_hunter.model;

    opens com.seu.sponsor_hunter.service to javafx.fxml;
    exports com.seu.sponsor_hunter.service;
}