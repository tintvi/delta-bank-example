package me.tintvi.Bank.bank.serialization;

import me.tintvi.Bank.accounts.serialization.AccountJsonSerializationObject;

import java.util.ArrayList;

public class BankJsonSerializationObject {
    public ArrayList<AccountJsonSerializationObject> accountList = new ArrayList<>();
}
