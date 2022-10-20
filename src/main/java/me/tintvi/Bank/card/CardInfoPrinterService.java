package me.tintvi.Bank.card;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CardInfoPrinterService {

    public void printCardInfo(BaseCard card) {
        System.out.println("Card number: " + card.getCardNumber() + ", expiration: " + card.getExpiration() + ", CVC: " + card.getCvc());
    }

    public void printAccountCards(BaseAccount account) {
        System.out.println("-- List of cards linked to account " + account.getAccountNumber() + " --");
        for(BaseCard card : account.getAccountCards()) {
            printCardInfo(card);
        }
    }
}
