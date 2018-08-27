package com.photoncat.digitalpet.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DigitalPet extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        DigitalPetMain controller = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("digital_pet_main.fxml"));
            root = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final DigitalPetMain controllerFinal = controller;
        assert controllerFinal != null;

        Scene scene = new Scene(root);

        primaryStage.setTitle("Digital Pet");
        primaryStage.setScene(scene);
        primaryStage.setOnHidden((event)->controllerFinal.shutdown());
        primaryStage.show();
    }
}
