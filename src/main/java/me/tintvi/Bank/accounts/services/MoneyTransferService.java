package me.tintvi.Bank.accounts.services;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.cheque.BaseCheque;
import me.tintvi.Bank.cheque.ChequeCreatorService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MoneyTransferService {
    BankFeeCalculator feeCalculator;

    @Inject
    ChequeCreatorService chequeCreatorService;

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

    public void withdrawMoney(BaseAccount sender, float amount) {
        if(sender.removeBalance(amount)) {
            //recipient.addBalance(feeCalculator.deductPaymentFee(sender, amount));
            System.out.println("You have received " + amount + " of money. Enjoy!");
        }
        else {
            System.out.println("The sender account does not have enough money to send!");
        }
    }

    public void useCheque(BaseCheque cheque, float amount) {
        if (chequeCreatorService.checkCheque(cheque)) {
            if(cheque.getAccount().removeBalance(amount)) {
                //recipient.addBalance(feeCalculator.deductPaymentFee(sender, amount));
                cheque.getAccount().removeCheque(cheque);
                chequeCreatorService.removeCheque(cheque);
                System.out.println("You have received " + amount + " of money. Enjoy!");
            }
            else {
                System.out.println("The sender account does not have enough money to send!");
            }
        }
        else {
            System.out.println("This cheque does not exist!");
        }

    }
}
