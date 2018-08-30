package com.photoncat.digitalpet.ui;

import com.photoncat.digitalpet.Pet;
import com.photoncat.digitalpet.Statuses;

public class DummyPet implements Pet {
    double x = 0;
    double y = 0;

    @Override
    public Statuses doNothing(long timestamp) {
        x = 100 + 50 * Math.cos(timestamp / 5.);
        y = 100 + 50 * Math.sin(timestamp / 8.);
        return new Statuses.Builder().setX(x).setY(y).build();
    }

    @Override
    public Statuses feed(long timestamp) {
        return null;
    }

    @Override
    public Statuses bath(long timestamp) {
        return null;
    }
}
