package me.tintvi.Bank.accounts.services;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.accountTypes.SavingsAccount;
import me.tintvi.Bank.accounts.accountTypes.StudentAccount;

import javax.inject.Singleton;

@Singleton
public class AccountInfoPrinterService {
    public void printAccountBalance(BaseAccount account) {
        System.out.println("Balance of " + account.getOwner().getFullName() + " (" + account.getAccountNumber() + ") is " + account.getBalance());
    }

    private String getTypePrefix(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return "[Student] ";
        }

        if (account instanceof SavingsAccount) {
            return "[Saving] ";
        }

        return "[Base] ";
    }
}