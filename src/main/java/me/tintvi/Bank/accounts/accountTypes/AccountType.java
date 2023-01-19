package me.tintvi.Bank.accounts.accountTypes;

public enum AccountType {
    BaseAccount,
    SavingsAccount,
    StudentAccount,
    CreditCardAccount;

    public static AccountType getAccountTypeFromClassname(String className) {
        switch (className) {
            case "CreditCardAccount": return CreditCardAccount;
            case "SavingsAccount": return SavingsAccount;
            case "StudentAccount": return StudentAccount;
            default: return BaseAccount;
        }
    }
}
