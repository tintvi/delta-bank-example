package me.tintvi.Bank.accounts;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.accountTypes.SavingsAccount;
import me.tintvi.Bank.accounts.accountTypes.StudentAccount;
import me.tintvi.Bank.person.Person;
import me.tintvi.Bank.person.PersonFactory;

@Singleton
public class AccountFactory {

    @Inject
    PersonFactory personFactory;

    public BaseAccount createBaseAccount(String accountNumber, Person person, float balance) {
        return new BaseAccount(accountNumber, person, balance);
    }

    public StudentAccount createStudentAccount(String accountNumber, Person person, float balance) {
        return new StudentAccount(accountNumber, person, balance);
    }

    public SavingsAccount createSavingsAccount(String accountNumber, Person person, float balance) {
        return new SavingsAccount(accountNumber, person, balance);
    }
}
