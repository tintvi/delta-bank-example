package me.tintvi.Bank.bank;

import me.tintvi.Bank.actions.ActionProcessService;
import me.tintvi.Bank.atm.AtmCreationService;
import me.tintvi.Bank.atm.AtmInfoPrinterService;
import me.tintvi.Bank.atm.AtmWithdrawService;
import me.tintvi.Bank.atm.BaseAtm;
import me.tintvi.Bank.bank.serialization.BankJsonSerializationObjectFactory;
import me.tintvi.Bank.accounts.accountTypes.AccountType;
import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.tintvi.Bank.accounts.serialization.AccountJsonSerializationObjectFactory;
import me.tintvi.Bank.accounts.services.AccountCreationService;
import me.tintvi.Bank.accounts.services.AccountInfoPrinterService;
import me.tintvi.Bank.accounts.services.InterestManagerService;
import me.tintvi.Bank.accounts.services.MoneyTransferService;
import me.tintvi.Bank.card.BaseCard;
import me.tintvi.Bank.card.CardCreatorService;
import me.tintvi.Bank.card.CardInfoPrinterService;
import me.tintvi.Bank.menu.Menu;
import me.tintvi.Bank.menu.MenuChoices;
import me.tintvi.Bank.person.Person;
import me.tintvi.Bank.person.PersonFactory;
import me.tintvi.Bank.storage.GsonSerializationService;
import me.tintvi.Bank.storage.IOFileStorageService;

import javax.inject.Inject;

public class Bank {
    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private InterestManagerService interestManagerService;

    @Inject
    private PersonFactory personFactory;

    @Inject
    private AccountCreationService accountCreationService;

    @Inject
    private CardCreatorService cardCreatorService;

    @Inject
    private CardInfoPrinterService cardInfoPrinterService;

    @Inject
    public Bank(AccountInfoPrinterService accountInfoPrinterService) {
//        this.registerActions();
    }

    @Inject
    BankJsonSerializationObjectFactory bankJsonSerializationObjectFactory;

    @Inject
    private IOFileStorageService storage;

    @Inject
    private AccountJsonSerializationObjectFactory accountJsonSerializationObjectFactory;

    @Inject
    private GsonSerializationService gsonSerializationService;

    @Inject
    ActionProcessService actionProcessService;

    @Inject
    AtmCreationService atmCreationService;

    @Inject
    AtmInfoPrinterService atmInfoPrinterService;

    @Inject
    AtmWithdrawService atmWithdrawService;

//    public void startTerminal() {
//        System.out.println("Hello from bank application!");
//
//        Menu menu = new Menu();
//        menu.printMenu();
//
//        while (true) {
//            MenuChoices choice = menu.read();
//
//            if (choice == MenuChoices.EXIT) {
//                break;
//            }
//
//            actionProcessService.processAction(choice);
//        }
//    }

    public void example() {

        Person owner = this.personFactory.createPerson("Matej", "Neumann", 1);

        BaseAccount accountOne = this.accountCreationService.createAccount(AccountType.StudentAccount, owner, 1000);
        BaseAccount accountTwo = this.accountCreationService.createAccount(AccountType.BaseAccount, owner, 1000);
        BaseAccount accountThree = this.accountCreationService.createAccount(AccountType.SavingsAccount, owner, 1000);


        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        this.accountInfoPrinterService.printAccountBalance(accountThree);
        System.out.println();

        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        System.out.println();


        interestManagerService.addInterests();

        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        this.accountInfoPrinterService.printAccountBalance(accountThree);
        System.out.println();

        this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountOne);

        this.cardInfoPrinterService.printAccountCards(accountOne);




        String json = gsonSerializationService.serialize(bankJsonSerializationObjectFactory.createFromBank());
        System.out.println(json);

        storage.save(json, "bank.json");

        String jsonFile = storage.load("accounts.json");
        AccountJsonSerializationObject deserializedAccount = gsonSerializationService.deserialize(jsonFile, AccountJsonSerializationObject.class);
        System.out.println(deserializedAccount.accountNumber);
        BaseAccount deserializedBase = accountCreationService.createAccount(deserializedAccount);
    }

    public void atmExample(){

        Person owner = this.personFactory.createPerson("vitek", "tintera", 1);
        BaseAccount myAccount = this.accountCreationService.createAccount(AccountType.StudentAccount, owner, 1000);
        this.accountInfoPrinterService.printAccountBalance(myAccount);

        BaseCard myCard = this.cardCreatorService.createCardAndSetIntoAccount(myAccount);
        this.cardInfoPrinterService.printAccountCards(myAccount);

        BaseAtm ATM = atmCreationService.createAtm();

        this.atmInfoPrinterService.getAccountBalance(myCard);

        this.atmWithdrawService.WithdrawMoney(myCard, 500);

        this.atmInfoPrinterService.getAccountBalance(myCard);
    }
}