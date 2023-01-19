package me.tintvi.Bank.card;

import com.google.inject.Guice;
import me.tintvi.Bank.BankInjectorTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class CardCreatorServiceTest {

    @Inject
    CardCreatorService cardCreatorService;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    public void testInjectBaseService() throws Exception {
        assertNotNull(this.cardCreatorService);
        assertInstanceOf(CardCreatorService.class, this.cardCreatorService);
    }

    @Test
    public void testAreServicesInjected() throws Exception {
        assertNotNull(this.cardCreatorService);
        assertInstanceOf(CardFactory.class, this.cardCreatorService.getCardFactory());
        assertInstanceOf(CardNumberGeneratorService.class, this.cardCreatorService.cardNumberGeneratorService());
    }

    //test pro createaccoint service
}