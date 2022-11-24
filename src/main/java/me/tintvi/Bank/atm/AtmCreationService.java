package me.tintvi.Bank.atm;

import me.tintvi.Bank.accounts.accountTypes.AccountType;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.person.Person;

import javax.inject.Singleton;

@Singleton
public class AtmCreationService {

    public BaseAtm createAtm(){
        return new BaseAtm();
    }

}
