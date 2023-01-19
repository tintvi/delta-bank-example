package me.tintvi.Bank.accounts.accountTypes;

import me.tintvi.Bank.card.BaseCard;
import me.tintvi.Bank.card.CardCreatorService;
import me.tintvi.Bank.person.Person;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CreditCardAccount extends BaseAccount{

    @Inject
    CardCreatorService cardCreatorService;

    public final float limit;

    public CreditCardAccount (String accountNumber, Person owner, float limit) {
        super(accountNumber, owner, limit);
        this.limit = limit;
        cardCreatorService.createCardAndSetIntoAccount(this); //creates the credit card
    }

    public BaseCard getCreditCard() {
        BaseCard[] arrayOfCards = (BaseCard[]) (this.cards.values().toArray());
        BaseCard card = arrayOfCards[0];
        return card; //returns just the first card of the account, which is the credit card created in the constructor
    }


    //stuff below is bad and might not work, but it's never used, so it's probably fine?
    @Override
    public void addCard(BaseCard card) {
        super.addCard(card);
    }

    @Override
    public void addMultipleCards(List<BaseCard> cardList) {
        super.addMultipleCards(cardList);
    }

    @Override
    public ArrayList<BaseCard> getAccountCards() {
        return super.getAccountCards();
    }

}
