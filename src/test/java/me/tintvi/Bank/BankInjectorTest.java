package me.tintvi.Bank;

import com.google.inject.AbstractModule;
import me.tintvi.Bank.card.CardDataGeneratorServiceMock;
import me.tintvi.Bank.card.CardNumberGeneratorService;

public class BankInjectorTest extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();

        bind(CardNumberGeneratorService.class).to(CardDataGeneratorServiceMock.class);
    }
}
