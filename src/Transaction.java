import java.util.Date;

public class Transaction {

    /**
     * The amount of this transaction.
     */
    private double amount;

    /**
     * The date of this transaction.
     */
    private Date date;

    /**
     * The title of this transaction.
     */
    private String title;

    /**
     * The bank account in which this transaction is executed.
     */
    private Account account;

    /**
     * Create a new Transaction object.
     * @param amount            the amount of the transaction
     * @param title             the title of the transaction
     * @param theAccount        the account which the transaction is executed
     */
    public Transaction (double amount, String title, Account theAccount) {

        this.amount = amount;
        date = new Date();
        this.title = title;
        account = theAccount;
    }

    public double getAmount() {
        return amount;
    }
}
