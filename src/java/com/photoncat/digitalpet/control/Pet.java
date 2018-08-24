package com.photoncat.digitalpet.control;

import com.photoncat.digitalpet.Statuses;

public class Pet implements com.photoncat.digitalpet.Pet{

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
