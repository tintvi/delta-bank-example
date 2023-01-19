package me.tintvi.Bank.accounts.services;

import me.tintvi.Bank.accounts.AccountFactory;
import me.tintvi.Bank.accounts.AccountNumberGenerator;
import me.tintvi.Bank.accounts.AccountStorageService;
import me.tintvi.Bank.accounts.accountTypes.AccountType;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.accountTypes.CreditCardAccount;
import me.tintvi.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.tintvi.Bank.card.CardCreatorService;
import me.tintvi.Bank.person.Person;
import me.tintvi.Bank.person.PersonFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountCreationService {

    @Inject
    AccountNumberGenerator accountNumberGenerator;

    @Inject
    AccountFactory accountFactory;

    @Inject
    AccountStorageService accountStorageService;

    @Inject
    PersonFactory personFactory;

    @Inject
    CardCreatorService cardCreatorService;


    public BaseAccount createAccount(AccountType type, Person person, float balance) {
        String accountNum = accountNumberGenerator.getRandomAccountNumber();

        BaseAccount account = switch(type) {
            case BaseAccount -> this.accountFactory.createBaseAccount(accountNum, person, balance);
            case SavingsAccount -> this.accountFactory.createSavingsAccount(accountNum, person, balance);
            case StudentAccount -> this.accountFactory.createStudentAccount(accountNum, person, balance);
            case CreditCardAccount -> this.accountFactory.createCreditCardAccount(accountNum, person, balance);
        };

        accountStorageService.addAccount(account);

        return account;
    }

    public BaseAccount createAccount(AccountJsonSerializationObject serializedAccount) {
        String accountNum = serializedAccount.accountNumber;

        BaseAccount account = switch(AccountType.getAccountTypeFromClassname(serializedAccount.accountType)) {
            case BaseAccount -> this.accountFactory.createBaseAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
            case SavingsAccount -> this.accountFactory.createSavingsAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
            case StudentAccount -> this.accountFactory.createStudentAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
            case CreditCardAccount -> this.accountFactory.createCreditCardAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
        };

        accountStorageService.addAccount(account);

        cardCreatorService.deserializeCardListAndSetIntoAccount(serializedAccount.cards, account);

        return account;
    }
}
