package me.tintvi.Bank.atm;

import java.util.Random;

public class BaseAtm {
    private int ID;

    Random generator = new Random();

    public BaseAtm(){
        ID = generator.nextInt(100);
    }

    public int getAtmId(){return ID;}
}
