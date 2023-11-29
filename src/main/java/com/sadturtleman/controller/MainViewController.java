package com.sadturtleman.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainViewController {

    @FXML TextField search_text;
    @FXML ListView<String> listview;

    int i = 0;
    @FXML
    private void search(){
        listview.getItems().add(String.valueOf(i++));
    }

    @FXML
    private void openlink(){
        System.out.println(listview.getSelectionModel().getSelectedItem());
    }
}