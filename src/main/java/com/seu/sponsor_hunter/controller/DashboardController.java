package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{

    @FXML
    private ImageView welcome;

    @FXML
    void clickHire(ActionEvent event) {
        Main.changeScene("hireInfluencers",900,600);
    }

    @FXML
    void clickRegister(ActionEvent event) {
        Main.changeScene("influencerRegister",900,600);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("D:\\Programming\\Java\\SEU\\CSE281.5\\Projects\\Sponsor Hunter\\src\\main\\java\\com\\seu\\sponsor_hunter\\image\\welcome.png");
        welcome.setImage(image);
    }
}