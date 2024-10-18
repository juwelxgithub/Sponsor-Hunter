package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HireInfluencersController {

    @FXML
    void clickHire(ActionEvent event) {
        Main.changeScene("hireInfluencers",900,600);
    }

}
