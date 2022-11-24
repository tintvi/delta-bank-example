package me.tintvi.Bank.accounts.observers;

import me.tintvi.Bank.Observer.Observer;
import me.tintvi.Bank.Observer.ObserverSubject;

import java.util.List;

public class EmailSubject implements ObserverSubject {

    public List<Observer> observers = null;
    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() { //only when new account is created

    }

    @Override
    public void removeObserver(Observer observer) {

    }
}
