package me.tintvi.Bank.accounts;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;

@Singleton
public class AccountStorageService {
    private final HashMap<String, BaseAccount> accounts = new HashMap<>();

    public void addAccount(BaseAccount account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public ArrayList<BaseAccount> getAccounts() {
        return new ArrayList<>(this.accounts.values());
    }

//    public BaseAccount findAccount(String accountNumber) {
//        for(BaseAccount account : accounts) {
//            if(account.getAccountNumber().equals(accountNumber))
//                return account;
//        }
//        return null;
//    }

    public BaseAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}