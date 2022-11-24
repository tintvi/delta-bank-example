package me.tintvi.Bank.atm;

import me.tintvi.Bank.accounts.services.AccountInfoPrinterService;
import me.tintvi.Bank.card.BaseCard;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AtmInfoPrinterService {

    @Inject AccountInfoPrinterService accountInfoPrinterService;

    public void getAccountBalance(BaseCard card) {

    accountInfoPrinterService.printAccountBalance(card.getAccount());

    }
}
