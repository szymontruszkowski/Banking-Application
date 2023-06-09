import java.util.ArrayList;
import java.util.List;

public class Account {

    /**
     * The type of this account.
     */
    private String type;

    /**
     * The id number of this account.
     */
    private String id;

    /**
     * The currency of this account.
     */
    private String currency;

    /**
     * The owner of this account.
     */
    private Customer owner;

    /**
     * The list of transactions executed in this account.
     */
    private List<Transaction> transactions;

    /**
     * Create a new Account object.
     * @param type              the type of the account
     * @param currency          the currency of the account
     * @param theCustomer       the owner of the account
     * @param theBank           the bank which the account is registered in
     */
    public Account(String type, String currency, Customer theCustomer, Bank theBank) {

        this.type = type;
        id = theBank.getNewAccountId();
        this.currency = currency;
        owner = theCustomer;
        transactions = new ArrayList<>();

        System.out.printf("\nNew %s account has been successfully created with ID %s.\n", type.toLowerCase(), id);
    }

    /**
     * Get the ID number of the account.
     * @return      the ID number
     */
    public String getId() {
        return id;
    }

    /**
     * Get the summary line for the account.
     * @return      the summary line
     */
    public String getSummaryLine() {

        double balance = getBalance();
        return String.format("%s : %.02f%s : %s", id, balance, currency, type);
    }

    /**
     * Get the balance of the account.
     * @return      the balance
     */
    public double getBalance() {

        double balance = 0;

        for (Transaction t : transactions) {
            balance += t.getAmount();
        }

        return balance;
    }

    /**
     * Print the summary line for each transaction of the account.
     */
    public void printTransHistory() {

        System.out.printf("\nTransaction history for account %s\n", id);
        for (int t = transactions.size()-1; t >= 0; t--) {
            System.out.println(transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * Get the currency of the account.
     * @return      the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Create a new transaction and add it to the list of transactions.
     * @param amount        the amount of the transaction
     * @param title         the title of the transaction
     */
    public void addTransaction(double amount, String title) {

        Transaction newTrans = new Transaction(amount, title, this);
        transactions.add(newTrans);
    }
}
