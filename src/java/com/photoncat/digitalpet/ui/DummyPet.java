package com.photoncat.digitalpet.ui;

import com.photoncat.digitalpet.Pet;
import com.photoncat.digitalpet.Statuses;

public class DummyPet implements Pet {
    @Override
    public Statuses doNothing(long timestamp) {
        return null;
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
