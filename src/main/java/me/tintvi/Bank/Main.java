package me.tintvi.Bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.tintvi.Bank.bank.Bank;
import me.tintvi.Bank.bank.BankInjector;

public class Main {

    public static void main(String[] args) {

//        Scanner s = new Scanner(new InputStreamReader(System.in));
//        System.out.println(s.next());


        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        bank.startTerminal();
    }
}