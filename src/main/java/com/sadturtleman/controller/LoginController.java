package com.sadturtleman.controller;

import java.io.IOException;

import com.sadturtleman.App;

import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void login() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void signUp() throws IOException {
        System.out.println(1);
    }
}
