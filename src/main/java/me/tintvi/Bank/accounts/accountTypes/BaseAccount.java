package me.tintvi.Bank.accounts.accountTypes;

import me.tintvi.Bank.card.BaseCard;
import me.tintvi.Bank.cheque.BaseCheque;
import me.tintvi.Bank.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseAccount {
    private float balance;
    private Person owner;
    protected HashMap<String, BaseCard> cards = new HashMap<>();

    protected HashMap<String, BaseCheque> cheques = new HashMap<>();
    private String accountNumber;



    public BaseAccount(String accountNumber, Person owner, float initialBalance) {
        this.balance = initialBalance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }

    public void addBalance(float amount) {
        this.balance += amount;
    }

    public boolean removeBalance(float amount) {
        if(amount > balance) return false;
        balance -= amount;
        return true;
    }

    public Person getOwner() {
        return owner;
    }

    public void addCard(BaseCard card) {
        this.cards.put(card.getCardNumber(), card);
    }

    public void addMultipleCards(List<BaseCard> cardList) {
        for(BaseCard card : cardList) {
            this.addCard(card);
        }
    }

    public void addCheque(BaseCheque cheque) { this.cheques.put(cheque.getChequeNumber(), cheque); }

    public void removeCheque(BaseCheque cheque) { this.cheques.remove(cheque.getChequeNumber(), cheque); }

    public int getCardCount() {
        return this.cards.size();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public ArrayList<BaseCard> getAccountCards() {
        return new ArrayList<>(this.cards.values());
    }
}
