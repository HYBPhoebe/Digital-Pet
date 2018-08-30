package com.photoncat.digitalpet.control;

import com.photoncat.digitalpet.Statuses;

public class Pet implements com.photoncat.digitalpet.Pet {
    private int hunger = 0;
    private long timestamp;
    private int cleanness;
    private int pro = 0;//last hunger value;

    private long protime;//last post time;
    private int pc = 100;//last cleanness value;
    private int n = 0;//time difference;
    private int c = 0;// cleaness difference;

    private Statuses getStatusesObject() {
        return new Statuses.Builder()
                .setTimestamp(timestamp)
                .setHunger(hunger)
                .setCleanness(cleanness)
                .build();
    }

    public Statuses doNothing(long timestamp) {
        if (protime == 0) {
            protime = timestamp;
        } else {

            hunger = (int) (pro + (timestamp - protime) / 10);

            if (hunger > 100) {
                hunger = 100;
                pro = hunger;
            } else {
                pro = hunger;
            }

            cleanness = (int) (pc - ((timestamp - protime)) / 10);
            if (cleanness < 0) {
                cleanness = 0;
                pc = cleanness;
            } else {
                pc = cleanness;
            }

            if ((timestamp - protime) < 10) {
                n -= (int) (timestamp - protime);
            } else {
                n -= 10;
                protime = timestamp;
            }
        }
        return getStatusesObject();
    }

    @Override
    public Statuses feed(long timestamp) {
        hunger = pro - 20;
        while (hunger < 0) {
            hunger = 0;
        }
        pro = hunger;

        return getStatusesObject();
    }

    @Override
    public Statuses bath(long timestamp) {
        cleanness = pc + 20;
        while (cleanness > 100) {
            cleanness = 100;
        }
        pc = cleanness;

        return getStatusesObject();
    }
}
