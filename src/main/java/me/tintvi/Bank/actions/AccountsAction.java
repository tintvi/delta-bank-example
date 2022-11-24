package me.tintvi.Bank.actions;

import me.tintvi.Bank.accounts.AccountStorageService;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.services.AccountInfoPrinterService;

import javax.inject.Inject;

public class AccountsAction implements Action{


    @Inject
    AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    AccountStorageService accountStorageService;

    @Override
    public void processAction() {
        for (BaseAccount acc : accountStorageService.getAccounts()) {
            accountInfoPrinterService.printAccountType(acc);
        }
    }
}
