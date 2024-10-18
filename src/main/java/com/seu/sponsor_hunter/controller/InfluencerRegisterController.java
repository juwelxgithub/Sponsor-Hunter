package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import javafx.fxml.FXML;

public class InfluencerRegisterController {
    @FXML
    void clickHire(){
        Main.changeScene("hireInfluencers", 900,600);
    }
}
