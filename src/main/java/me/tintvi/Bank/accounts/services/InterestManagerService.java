package me.tintvi.Bank.accounts.services;

import me.tintvi.Bank.accounts.AccountStorageService;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.accountTypes.InterestAccountInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class InterestManagerService {
    InterestCalculator interestCalculator;

    @Inject
    private AccountStorageService accountStorageService;

    public InterestManagerService() {
        interestCalculator = new InterestCalculator();
    }

    public void addInterests() {
        for (BaseAccount account : accountStorageService.getAccounts()) {
            if (account instanceof InterestAccountInterface) {
                float amount = interestCalculator.calculateInterest(account);
                account.addBalance(amount);
            }
        }
    }
}
