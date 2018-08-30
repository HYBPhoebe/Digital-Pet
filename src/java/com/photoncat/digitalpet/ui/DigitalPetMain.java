package com.photoncat.digitalpet.ui;

import com.photoncat.digitalpet.Pet;
import com.photoncat.digitalpet.Statuses;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalPetMain {
    @FXML public Label hungerValue;
    @FXML public ProgressBar hungerProgress;
    @FXML public Label cleannessValue;
    @FXML public ProgressBar cleannessProgress;
    @FXML public ImageView petImage;

    private Pet pet = new com.photoncat.digitalpet.control.Pet();
//    private Pet pet = new DummyPet();
    private Timer idleTimer = new Timer();

    @FXML
    protected void initialize() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->update(pet.doNothing(getTimestamp())));
            }
        };
        idleTimer.scheduleAtFixedRate(task, 0, 500);

        BufferedImage image = null;
        try {
            InputStream ins = this.getClass().getResourceAsStream("/res/Pet.png");
            image = ImageIO.read(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image != null) {
            Image pet = SwingFXUtils.toFXImage(image, null);
            petImage.setImage(pet);
        }
    }

    @FXML
    public void shutdown() {
        idleTimer.cancel();
    }

    private long getTimestamp() {
        return System.currentTimeMillis() / 100;
    }

    public void feed() {
        update(pet.feed(getTimestamp()));
    }

    public void bath() {
        update(pet.bath(getTimestamp()));
    }

    private void update(Statuses statuses) {
        hungerValue.setText(statuses.getHunger() + "/100");
        hungerProgress.setProgress(statuses.getHunger() / 100f);
        cleannessValue.setText(statuses.getCleanness() + "/100");
        cleannessProgress.setProgress(statuses.getCleanness() / 100f);
        petImage.setLayoutX(statuses.getX());
        petImage.setLayoutY(statuses.getY());
    }
}
