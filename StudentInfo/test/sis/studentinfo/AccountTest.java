package sis.studentinfo;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class AccountTest extends TestCase {
    public static final String ABA = "102000012";
    public static final String ACCOUNT_NUMBER = "194431518811";

    private Account account;

    protected void setUp() {
        account = new Account();

        account.setBankAba(ABA);
        account.setBankAccountNumber(ACCOUNT_NUMBER);
        account.setBankAccountType(Account.BankAccountType.CHECKING);
    }

    public void testTransferFromBank() {
//        account.setAch(new com.jimbo.ach.JinBobAch());
        account.setAch(new MockAch());

        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);

        assertEquals(amount, account.getBalance());
    }

    public void testTransactions() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));

        assertEquals(new BigDecimal("11.10"), account.getBalance());

        assertEquals(new BigDecimal("5.300"),
                new BigDecimal("5.000").add(new BigDecimal("0.3")));
    }

    public void testTransactionAverage() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));

        assertEquals(new BigDecimal("4.70"), account.transactionAverage());
    }
}
