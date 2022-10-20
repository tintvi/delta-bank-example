package me.tintvi.Bank.bank;

import me.tintvi.Bank.bank.serialization.BankJsonSerializationObject;
import me.tintvi.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.tintvi.Bank.accounts.services.AccountCreationService;
import me.tintvi.Bank.storage.GsonSerializationService;
import me.tintvi.Bank.storage.IOFileStorageService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankCreationService {

    @Inject
    AccountCreationService accountCreationService;
    @Inject
    IOFileStorageService ioFileStorageService;

    @Inject
    GsonSerializationService gsonSerializationService;

    public void createFromSerializedBankJsonObject(BankJsonSerializationObject b){
        for(AccountJsonSerializationObject a : b.accountList) {
            accountCreationService.createAccount(a);
        }
    }

    public void createFromFileStorage() {
        String jsonFile = ioFileStorageService.load("bank.json");
        BankJsonSerializationObject serializedBank = gsonSerializationService.deserialize(jsonFile, BankJsonSerializationObject.class);
        createFromSerializedBankJsonObject(serializedBank);
    }
}
