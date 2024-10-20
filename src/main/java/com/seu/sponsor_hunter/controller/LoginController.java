package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ImageView bg;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private TextField userNameLogin;

    @FXML
    void clickLogin(ActionEvent event) {
        try{
            RandomAccessFile raf = new RandomAccessFile("userInfo.txt", "r");
            boolean loggedIn = false;
            String line;
            while((line = raf.readLine()) != null){
                String[] info  = line.split(",");
                String username = info[0];
                String password = info[1];

                if(userNameLogin.getText().equals(username) && passwordLogin.getText().equals(password)){
                    Main.changeScene("dashboard",900,600);
                    loggedIn = true;
                    //confirmation msg
                    System.out.println("Login Successful");
                    break;
                }
            }if(!loggedIn){
                //alertbox
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username or password");
                alert.setContentText("Please check your username and password and try again.");
                alert.showAndWait();

                //confirmation msg
                System.out.println("Invalid username or password");

                //clear screen
                userNameLogin.clear();
                passwordLogin.clear();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("D:\\Programming\\Java\\SEU\\CSE281.5\\Projects\\Sponsor Hunter\\src\\main\\java\\com\\seu\\sponsor_hunter\\image\\login.png");
        bg.setImage(image);
    }
}
