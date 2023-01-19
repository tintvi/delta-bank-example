package me.tintvi.Bank.card;

public class CardDataGeneratorServiceMock extends CardNumberGeneratorService{

    @Override
    public String generateCardNumber(){
        return "hmmyesdata";
    }
}
