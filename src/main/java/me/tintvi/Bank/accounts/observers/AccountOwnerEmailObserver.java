package me.tintvi.Bank.accounts.observers;

import me.tintvi.Bank.Observer.Observer;

public class AccountOwnerEmailObserver implements Observer {
    @Override
    public void update() {
        //send an email to account owner
        System.out.println("Sending an email to the customer!");
    }
}
