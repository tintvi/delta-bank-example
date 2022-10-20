package me.tintvi.Bank.bank.serialization;

import me.tintvi.Bank.accounts.AccountStorageService;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.serialization.AccountJsonSerializationObjectFactory;

import javax.inject.Inject;

public class BankJsonSerializationObjectFactory {

    @Inject
    private AccountStorageService accountStorageService;

    @Inject
    AccountJsonSerializationObjectFactory accountJsonSerializationObjectFactory;

    public BankJsonSerializationObject createFromBank() {
        BankJsonSerializationObject serializedBank = new BankJsonSerializationObject();
        for(BaseAccount a : accountStorageService.getAccounts()) {
            serializedBank.accountList.add(accountJsonSerializationObjectFactory.createFromBaseAccount(a));
        }
        return serializedBank;
    }

}
