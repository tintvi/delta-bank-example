package me.tintvi.Bank.accounts.serialization;

import me.tintvi.Bank.card.serialization.CardJsonSerializationObject;
import me.tintvi.Bank.person.serialization.PersonJsonSerializationObject;

import java.util.ArrayList;
import java.util.List;

public class AccountJsonSerializationObject {
    public String accountType;
    public float balance;
    public PersonJsonSerializationObject owner;
    public List<CardJsonSerializationObject> cards = new ArrayList<>();
    public String accountNumber;
}
