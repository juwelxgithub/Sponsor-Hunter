package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import com.seu.sponsor_hunter.model.Influencer;
import com.seu.sponsor_hunter.service.InfluencerService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HireInfluencersController implements Initializable {

    @FXML
    private TableColumn<Influencer, String> emailCulomn;

    @FXML
    private TableColumn<Influencer, Number> followerCulomn;

    @FXML
    private TableView<Influencer> influencerTableView;

    @FXML
    private TableColumn<Influencer, String> nameCulomn;

    @FXML
    private TableColumn<Influencer, Number> priceCulomn;

    @FXML
    void clickRegister(ActionEvent event) {
        Main.changeScene("influencerRegister",900,600);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCulomn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        followerCulomn.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getFollower()));
        priceCulomn.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getPrice()));
        emailCulomn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));

        InfluencerService influencerService = new InfluencerService();
        List<Influencer> influencerList = influencerService.list();

        ObservableList<Influencer> influencerObservableList = FXCollections.observableArrayList();
        influencerObservableList.addAll(influencerList);

        influencerTableView.setItems(influencerObservableList);
    }
}
