package com.photoncat.digitalpet.ui;

import com.photoncat.digitalpet.Pet;
import com.photoncat.digitalpet.Statuses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class DigitalPetMain {
    @FXML public Label hungerValue;
    @FXML public ProgressBar hungerProgress;

    private Pet pet = new com.photoncat.digitalpet.control.Pet();
    private Timer idleTimer = new Timer();

    @FXML
    protected void initialize() {
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                Statuses statuses = pet.doNothing(getTimestamp());
                hungerValue.setText(statuses.getHunger() + "/100");
            }
        };
        idleTimer.scheduleAtFixedRate(task, 0, 500);
    }

    private long getTimestamp() {
        return System.currentTimeMillis() / 100;
    }

    public void feed() {
        Statuses statuses = pet.feed(getTimestamp());
        hungerValue.setText(statuses.getHunger() + "/100");
    }

    private void update() {

    }
}
