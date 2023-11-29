package com.sadturtleman.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

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
        String url = "https://in.naver.com//jvely//topic//633221870950688";
        Connection conn = Jsoup.connect(url);
        System.out.println(conn);
    }
}