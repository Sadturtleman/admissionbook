package com.sadturtleman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        scene = new Scene(loadFXML("LoginView"));
        stage.setTitle("입시 전형집");
        stage.setScene(scene);
        setSize(300, 200);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setSize(int x, int y){
        stage.setWidth(x);
        stage.setHeight(y);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}