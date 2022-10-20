package me.tintvi.Bank.accounts.services;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class MoneyTransferService {
    BankFeeCalculator feeCalculator;

    public MoneyTransferService() {
        this.feeCalculator = new BankFeeCalculator();
    }

    public void transferMoney(BaseAccount sender, BaseAccount recipient, float amount) {
        if(sender.removeBalance(amount)) {
            recipient.addBalance(feeCalculator.deductPaymentFee(sender, amount));
        }
        else {
            System.out.println("The sender account does not have enough money to send!");
        }
    }
}
