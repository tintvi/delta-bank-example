package me.tintvi.Bank.accounts.services;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.accountTypes.CreditCardAccount;
import me.tintvi.Bank.accounts.accountTypes.SavingsAccount;
import me.tintvi.Bank.accounts.accountTypes.StudentAccount;

import javax.inject.Singleton;

@Singleton
public class AccountInfoPrinterService {
    public void printAccountBalance(BaseAccount account) {
        if (account instanceof CreditCardAccount) {
            System.out.println("Limit of " + account.getOwner().getFullName() + " (" + account.getAccountNumber() + ") is " + ((CreditCardAccount) account).limit + " remaining balance is " + account.getBalance());
        }
        else {
            System.out.println("Balance of " + account.getOwner().getFullName() + " (" + account.getAccountNumber() + ") is " + account.getBalance());
        }

    }

    public void printAccountType(BaseAccount account){
        System.out.println(getTypePrefix(account) + "[Account number] " + account.getAccountNumber());
    }

    private String getTypePrefix(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return "[Student] ";
        }

        if (account instanceof SavingsAccount) {
            return "[Saving] ";
        }

        if (account instanceof CreditCardAccount){
            return "[CreditCard]";
        }

        return "[Base] ";
    }
}