package eu.sig.training.ch04;

// tag::CheckingAccount[]
public class CheckingAccount {
    private static final float INTEREST_PERCENTAGE = 0.01f;

    private Money balance = new Money();
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
        throws BusinessException {
        // 1. Check withdrawal limit:
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
        // 2. Assuming result is 9-digit bank account number, validate 11-test:
        int sum = SummaryUtil.sum(counterAccount);
        if (sum % 11 == 0) {
            // 3. Look up counter account and make transfer object:
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount);
            return result;
        } else {
            throw new BusinessException("Invalid account number!");
        }
    }

    public void addInterest() {
        SummaryUtil.addInterest(balance, INTEREST_PERCENTAGE);
    }
}
// end::CheckingAccount[]
