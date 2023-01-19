package me.tintvi.Bank.cheque;

import me.tintvi.Bank.accounts.accountTypes.BaseAccount;
import me.tintvi.Bank.card.BaseCard;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class ChequeCreatorService {

    @Inject ChequeFactory chequeFactory;

    private final HashMap<String, BaseCheque> cheques = new HashMap<>();


    public BaseCheque createChequeAndAssignToAccount(BaseAccount baseAccount, String chequeNumber) {

        BaseCheque cheque = this.chequeFactory.createBaseCheque(baseAccount, chequeNumber);
        baseAccount.addCheque(cheque);
        this.cheques.put(cheque.getChequeNumber(), cheque);
//        System.out.println(this.cheques.size());
        return cheque;
    }

    public void removeCheque(BaseCheque cheque) {
//        System.out.println("remove");
        this.cheques.remove(cheque.getChequeNumber());
    }

    public boolean checkCheque(BaseCheque cheque) {
//        System.out.println(this.cheques.size());
//        System.out.println(this.cheques.containsKey(cheque.getChequeNumber()));
//        System.out.println(cheque.getChequeNumber());
//        System.out.println(this.cheques.get(cheque.getChequeNumber()));
        return this.cheques.containsKey(cheque.getChequeNumber());
    }

    public ChequeFactory getChequeFactory() {
        return chequeFactory;
    }
}
