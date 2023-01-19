package me.tintvi.Bank.cheque;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;

import javax.inject.Singleton;


@Singleton
public class ChequeFactory {


    public BaseCheque createBaseCheque (BaseAccount baseAccount, String chequeNumber){
        return new BaseCheque(baseAccount, chequeNumber);
    }
}
