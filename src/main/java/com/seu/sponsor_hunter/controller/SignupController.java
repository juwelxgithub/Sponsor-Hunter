package com.seu.sponsor_hunter.controller;

import com.seu.sponsor_hunter.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    private PasswordField passwordSignup;

    @FXML
    private TextField userNameSignup;

    @FXML
    private ImageView bg;

    @FXML
    void clickSave(ActionEvent event) {
        String name = userNameSignup.getText();
        String password = passwordSignup.getText();

        String line = name + "," + password + "\n";

        try{
            RandomAccessFile raf = new RandomAccessFile("userInfo.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //load login page
        Main.changeScene("login",600,400);

        //confirmation msg
        System.out.println("Registration Successful");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("D:\\Programming\\Java\\SEU\\CSE281.5\\Projects\\Sponsor Hunter\\src\\main\\java\\com\\seu\\sponsor_hunter\\image\\login.png");
        bg.setImage(image);
    }
}