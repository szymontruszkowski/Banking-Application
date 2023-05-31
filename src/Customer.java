import java.util.ArrayList;
import java.util.List;

public class Customer {

    /**
     * The first name of this customer.
     */
    private String firstName;

    /**
     * The last name of this customer.
     */
    private String lastName;

    /**
     * The ID number of this customer.
     */
    private String id;

    /**
     * The password of this customer.
     */
    private String password;

    /**
     * The list of accounts of this customer.
     */
    private List<Account> accounts;

    public Customer(String firstName, String lastName, String password, String theBank) {

        this.firstName = firstName;
        this.lastName = lastName;
        id = theBank.getNewCustomerID();
        this.password = password;
        accounts = new ArrayList<>();

        System.out.println("New customer registered.");
    }
}
