package sis.studentinfo;

import com.jimbo.ach.Ach;
import com.jimbo.ach.AchCredentials;
import com.jimbo.ach.AchResponse;
import com.jimbo.ach.AchTransactionData;

import java.math.BigDecimal;

public class Account implements Accountable{
    private BigDecimal balance = new BigDecimal("0.00");
    private int transactionCount = 0;

    private String bankAba;

    private String bankAccountNumber;

    private BankAccountType bankAccountType;

    private Ach ach;

    public enum BankAccountType {
        CHECKING("ck"), SAVING("sv");

        private String value;
        private BankAccountType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public void credit(final BigDecimal amount) {
        balance = balance.add(amount);
        transactionCount++;
    }

    public void withdraw(BigDecimal amount) {
        synchronized(this) {
            if (amount.compareTo(balance) > 0)
                return;

            balance = balance.subtract(amount);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal transactionAverage() {
        return balance.divide(new BigDecimal(transactionCount), BigDecimal.ROUND_HALF_UP);
    }

    public void setBankAba(String bankAba) {
        this.bankAba = bankAba;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType= bankAccountType;
    }

    public void transferFromBank(BigDecimal amount) {
        AchCredentials credentials = createCredentials();

        AchTransactionData data = createData(amount);

        Ach ach = getAch();
        AchResponse achResponse = ach.issueDebit(credentials, data);

        credit(amount);
    }

    public AchCredentials createCredentials() {
        AchCredentials credentials = new AchCredentials();
        credentials.merchantID = "12355";
        credentials.userName = "sismerc1920";
        credentials.password = "pitseleh411";
        return credentials;
    }

    public AchTransactionData createData(BigDecimal amount) {
        AchTransactionData data = new AchTransactionData();
        data.description = "transfer from bank";
        data.amount = amount;
        data.aba = bankAba;
        data.account = bankAccountNumber;
        data.accountType = bankAccountType.toString();
        return data;
    }

    public Ach getAch() {
        return ach;
    }

    public void setAch(Ach ach) {
        this.ach = ach;
    }
}
