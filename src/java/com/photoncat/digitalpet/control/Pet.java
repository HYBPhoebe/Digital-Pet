package com.photoncat.digitalpet.control;

import com.photoncat.digitalpet.Statuses;

public class Pet implements com.photoncat.digitalpet.Pet{


    private int hunger=0;
    private long timestamp;
    private int cleanness;
    private int pro=0;//last hunger value;

    private long protime;//last post time;

    private int pc=100;//last cleanness value;
    private int n=0;//time difference;
    private int c=0;// cleaness difference;
    private Statuses pet= new com.photoncat.digitalpet.Statuses(timestamp, hunger, cleanness);


    public Statuses doNothing(long timestamp) {
        if (protime == 0) {
            protime = timestamp;
        } else {
            if (hunger <= 100) {
                hunger = (int) (pro + (timestamp - protime) / 0.5);
                if (hunger > 100) {
                    hunger = 100;
                }

                pro = hunger;
                cleanness = (int) (pc - (timestamp - protime) / 10);
                pc = cleanness;
                if ((timestamp - protime) < 10) {
                    n += (int) (timestamp - protime);
                } else {
                    n -= 10;
                    protime = timestamp;
                }
            } else {
                hunger = 100;
                pro = hunger;
            }
        }
                return new Statuses(timestamp, hunger, cleanness);

        }


    @Override
    public Statuses feed(long timestamp) {

         hunger=pro-20;
         if(hunger<0){
             hunger=0;
         }
         pro=hunger;

         return new Statuses(timestamp,hunger,0);

    }

    @Override
    public Statuses bath(long timestamp) {



       return null;

    }
}
