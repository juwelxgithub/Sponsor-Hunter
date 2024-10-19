package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginController {

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private TextField userNameLogin;

    @FXML
    void clickLogin(ActionEvent event) {
        try{
            RandomAccessFile raf = new RandomAccessFile("userInfo.txt", "r");
            String line;
            while((line = raf.readLine()) != null){
                String[] info  = line.split(",");
                String username = info[0];
                String password = info[1];

                if(userNameLogin.getText().equals(username) && passwordLogin.getText().equals(password)){
                    Main.changeScene("dashboard",900,600);

                    //confirmation msg
                    System.out.println("Login Successful");
                    break;
                }else {
                    //alertbox
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid username or password");
                    alert.setContentText("Please check your username and password and try again.");
                    alert.showAndWait();

                    //confirmation msg
                    System.out.println("Invalid username or password");
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void newAccount(ActionEvent event) {
        Main.changeScene("signup",600,400);
    }

}
