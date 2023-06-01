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

    public Account(String type, String currency, Customer theCustomer, Bank theBank) {

        this.type = type;
        id = theBank.getNewAccountID();
        this.currency = currency;
        owner = theCustomer;
        transactions = new ArrayList<>();
    }
}
