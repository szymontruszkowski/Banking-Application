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

    /**
     * Create a new Customer object.
     * @param firstName     the first name of the customer
     * @param lastName      the last name of the customer
     * @param password      the password of the customer
     * @param theBank       the bank which the customer is registered in
     */
    public Customer(String firstName, String lastName, String password, Bank theBank) {

        this.firstName = firstName;
        this.lastName = lastName;
        id = theBank.getNewCustomerId();
        this.password = password;
        accounts = new ArrayList<>();

        System.out.printf("""
                
                You have been successfully registered.\s
                Your ID number is %s.""", id);
    }

    /**
     * Get the ID number of the customer.
     * @return      the ID number
     */
    public String getId() {
        return id;
    }

    /**
     * Add a new account to the list of accounts.
     * @param newAccount        the account to add
     */
    public void addNewAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    /**
     * Get the password of the customer.
     * @return      the password
     */
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
