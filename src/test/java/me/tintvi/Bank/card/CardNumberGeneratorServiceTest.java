package me.tintvi.Bank.card;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class CardNumberGeneratorServiceTest {

    CardNumberGeneratorService cardNumberGeneratorService = new CardNumberGeneratorService();

    @Test
    void generateCardNumber() {
    }

    @Test
    void generateExpiration() {
        Calendar c = Calendar.getInstance();
        String expiration = cardNumberGeneratorService.generateExpiration();
        String[] separated = expiration.split("/");
        //assertTrue(separated[1] > c.get(Calendar.YEAR));
    }

    @Test
    void generateCvc() {
        String CVC = cardNumberGeneratorService.generateCvc();
        assertEquals(3, CVC.length());
    }
}