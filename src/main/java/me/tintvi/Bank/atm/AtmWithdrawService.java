package me.tintvi.Bank.atm;

import me.tintvi.Bank.accounts.services.MoneyTransferService;
import me.tintvi.Bank.card.BaseCard;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AtmWithdrawService {


    @Inject
    MoneyTransferService moneyTransferService;

    public void WithdrawMoney(BaseCard card, float amount){
        moneyTransferService.withdrawMoney(card.getAccount(), amount);
    }
}
