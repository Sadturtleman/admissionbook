package com.sadturtleman.controller;

import java.io.IOException;

import com.sadturtleman.App;

import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
