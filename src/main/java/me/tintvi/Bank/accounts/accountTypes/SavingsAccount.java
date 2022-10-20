package me.tintvi.Bank.accounts.accountTypes;

import me.tintvi.Bank.person.Person;

public class SavingsAccount extends BaseAccount implements InterestAccountInterface {
    public SavingsAccount(String accountNumber, Person owner, float startingBalance) {
        super(accountNumber ,owner, startingBalance);
    }

    @Override
    public float getInterest() {
        return 5;
    }
}
