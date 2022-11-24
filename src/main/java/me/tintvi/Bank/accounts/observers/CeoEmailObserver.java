package me.tintvi.Bank.accounts.observers;

import me.tintvi.Bank.Observer.Observer;

public class CeoEmailObserver implements Observer {
    @Override
    public void update() {
        //send an email to ceo
        System.out.println("Sending an email to the CEO!");
    }
}
