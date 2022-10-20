package me.tintvi.Bank.accounts.accountTypes;

public enum AccountType {
    BaseAccount,
    SavingsAccount,
    StudentAccount;

    public static AccountType getAccountTypeFromClassname(String className) {
        switch (className) {
            case "SavingsAccount": return SavingsAccount;
            case "StudentAccount": return StudentAccount;
            default: return BaseAccount;
        }
    }
}
