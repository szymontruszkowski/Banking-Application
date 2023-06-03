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
        id = theBank.getNewCustomerID();
        this.password = password;
        accounts = new ArrayList<>();

        System.out.printf("""
                
                You have been successfully registered.\s
                Your ID number is %s.""", id);
    }
    
    public String getID() {
        return id;
    }
}
