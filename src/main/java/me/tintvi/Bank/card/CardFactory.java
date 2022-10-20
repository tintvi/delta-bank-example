package me.tintvi.Bank.card;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CardFactory {

    public BaseCard createBaseCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        return new BaseCard(baseAccount, cardNumber, expiration, cvc);
    }
}
