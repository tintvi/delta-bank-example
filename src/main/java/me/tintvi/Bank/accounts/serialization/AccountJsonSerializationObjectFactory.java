package me.tintvi.Bank.accounts.serialization;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.card.serialization.CardJsonSerializationObjectFactory;
import me.tintvi.Bank.person.serialization.PersonJsonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountJsonSerializationObjectFactory {

    @Inject
    private PersonJsonSerializationObjectFactory personJsonSerializationObjectFactory;

    @Inject
    CardJsonSerializationObjectFactory cardJsonSerializationObjectFactory;

    public AccountJsonSerializationObject createFromBaseAccount(BaseAccount account) {
        AccountJsonSerializationObject a = new AccountJsonSerializationObject();
        a.accountNumber = account.getAccountNumber();
        a.balance = account.getBalance();
        a.owner = personJsonSerializationObjectFactory.createFromPerson(account.getOwner());
        a.accountType = account.getClass().getSimpleName();
        a.cards = cardJsonSerializationObjectFactory.createListFromCardList(account.getAccountCards());

        return a;
    }

}
