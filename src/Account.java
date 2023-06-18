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

    public double getBalance() {

        double balance = 0;

        for (Transaction t : transactions) {
            balance += t.getAmount();
        }

        return balance;
    }
}
