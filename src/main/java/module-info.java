module com.seu.sponsor_hunter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.seu.sponsor_hunter to javafx.fxml;
    exports com.seu.sponsor_hunter;
}