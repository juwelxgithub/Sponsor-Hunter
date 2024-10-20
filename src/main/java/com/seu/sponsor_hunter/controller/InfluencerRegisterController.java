package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import com.seu.sponsor_hunter.model.Influencer;
import com.seu.sponsor_hunter.service.InfluencerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InfluencerRegisterController implements Initializable {

    @FXML
    private TextField emailRegister;

    @FXML
    private TextField followerRegister;

    @FXML
    private TextField priceRegister;

    @FXML
    private TextField userNameRegister;
    @FXML
    private ImageView bg;

    @FXML
    void clickHire(ActionEvent event) {
        Main.changeScene("hireInfluencers", 900,600);
    }

    @FXML
    void Dashboard(){
        Main.changeScene("dashboard",900,600);
    }

    @FXML
    void saveAction(ActionEvent event) {
        String email = "*******@gmail.com";//emailRegister.getText();
        double follower = Double.parseDouble(followerRegister.getText());
        double price = Double.parseDouble(priceRegister.getText());
        String name = userNameRegister.getText();

        //adding info to model class
        Influencer influencer = new Influencer(name, follower, price, email);
        InfluencerService influencerService = new InfluencerService();
        influencerService.save(influencer);

        //confirmation msg
        System.out.println("Registration Successful");

        List<Influencer> influencerList = influencerService.list();

        ObservableList<Influencer> influencerObservableList = FXCollections.observableArrayList();
        influencerObservableList.addAll(influencerList);


        //clear text field
        userNameRegister.clear();;
        followerRegister.clear();
        priceRegister.clear();
        emailRegister.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("D:\\Programming\\Java\\SEU\\CSE281.5\\Projects\\Sponsor Hunter\\src\\main\\java\\com\\seu\\sponsor_hunter\\image\\influencerRegistration.png");
        bg.setImage(image);
    }
}
























