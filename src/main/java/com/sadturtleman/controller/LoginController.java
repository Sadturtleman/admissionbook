package com.sadturtleman.controller;

import java.io.IOException;

import com.sadturtleman.App;
import com.sadturtleman.model.Account;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML TextField Id;
    @FXML PasswordField Password;

    @FXML
    private void login() throws IOException {
        Account account = new Account(Id.getText(), Password.getText());
        if (account.isValidAccount()){
            App.setRoot("MainView");
            App.setSize(600, 400);
        }
        else{
            System.out.println("계정이 없습니다.");
        }
    }

    @FXML
    private void signUp() throws IOException {
        Account account = new Account(Id.getText(), Password.getText());
        account.signUp();
    }
}
