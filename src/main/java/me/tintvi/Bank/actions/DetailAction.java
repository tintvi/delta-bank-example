package me.tintvi.Bank.actions;

import me.tintvi.Bank.accounts.AccountStorageService;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.services.AccountInfoPrinterService;
import me.tintvi.Bank.person.Person;
import me.tintvi.Bank.person.PersonInfoPrinterService;
import me.tintvi.Bank.person.PersonStorageService;

import javax.inject.Inject;

public class DetailAction implements Action {

    @Inject
    AccountStorageService accountStorageService;

    @Inject
    AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    PersonStorageService personStorageService;

    @Inject
    PersonInfoPrinterService personInfoPrinterService;

    @Override
    public void processAction() {
        System.out.println("--- Loaded Persons --------------------------------");
        for(Person per : personStorageService.getPersonArray()) {
            personInfoPrinterService.printPersonInfo(per);
        }

        System.out.println("--- Loaded Accounts -------------------------------");
        for (BaseAccount acc : accountStorageService.getAccounts()) {
            accountInfoPrinterService.printAccountBalance(acc);
        }

        System.out.println("---------------------------------------------------");
    }
}
