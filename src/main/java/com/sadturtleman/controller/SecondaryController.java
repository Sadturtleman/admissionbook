package com.sadturtleman.controller;

import java.io.IOException;

import com.sadturtleman.App;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}