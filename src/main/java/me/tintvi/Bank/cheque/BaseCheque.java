package me.tintvi.Bank.cheque;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.card.BaseCard;

import java.util.HashMap;

public class BaseCheque {

    private transient BaseAccount baseAccount;

    private String chequeNumber;

    public BaseCheque(BaseAccount baseAccount, String chequeNumber) {
        this.baseAccount = baseAccount;
        this.chequeNumber = chequeNumber;
    }

    public BaseAccount getAccount() {return baseAccount;}

    public String getChequeNumber() {
        return chequeNumber;
    }

}
