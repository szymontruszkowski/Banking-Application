import java.util.ArrayList;
import java.util.List;

public class Bank {

    /**
     * The name of this bank.
     */
    private String name;

    /**
     * The list of customers of this bank.
     */
    private List<Customer> customers;

    /**
     * The list of accounts of this bank.
     */
    private List<Account> accounts;

    public Bank(String name) {

        this.name = name;
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }
}
