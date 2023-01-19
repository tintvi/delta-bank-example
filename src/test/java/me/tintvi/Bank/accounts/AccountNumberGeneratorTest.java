package me.tintvi.Bank.accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberGeneratorTest {

    AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();

    @Test
    void getRandomAccountNumber() {
        String number = accountNumberGenerator.getRandomAccountNumber();
        assertEquals(8, number.length());
        try{
            throw new Exception("eeeh");
        }
        catch (Exception e){
            assertTrue(true);
        }
    }
}