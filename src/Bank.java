import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * Create a new Bank object.
     * @param name      the name of the bank
     */
    public Bank(String name) {

        this.name = name;
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    /**
     * Get the unique ID number for a new customer.
     * @return      the ID number
     */
    public String getNewCustomerId() {

        String id;
        boolean isUnique;

        do {
            id = getNewID(5);
            isUnique = isUnique(id, "customer");
        } while (!isUnique);

        return id;
    }

    /**
     * Get the unique ID number for a new account.
     * @return      the ID number
     */
    public String getNewAccountId() {

        String id;
        boolean isUnique;

        do {
            id = getNewId(10);
            isUnique = isUnique(id, "account");
        } while (!isUnique);

        return id;
    }

    /**
     * Get randomly generated ID number.
     * @param length    the length of ID number
     * @return          the ID number
     */
    private String getNewId(int length) {

        Random random = new Random();
        String id = "";

        for (int d = 0; d <= length; d++) {
            id += ((Integer)random.nextInt(10)).toString();
        }
        return id;
    }

    /**
     * Check if the ID number is unique.
     * @param id        the ID number to be checked
     * @param holder    the holder of the ID number (customer or account)
     * @return          true, if the ID number is unique, or false, if it is not
     */
    private boolean isUnique(String id, String holder) {

        switch (holder) {
            case "customer":
            for (Customer c : customers) {
                if (id.compareTo(c.getId()) == 0) {
                    return false;
                }
            }

            case "account":
            for (Account a : accounts) {
                if (id.compareTo(a.getId()) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Create a new Customer object and add it to the list of customers.
     * @param firstName     the first name of the customer
     * @param lastName      the last name of the customer
     * @param password      the password of the customer
     * @return              a new Customer object
     */
    public Customer addNewCustomer(String firstName, String lastName, String password) {

        Customer newCustomer = new Customer(firstName, lastName, password, this);
        customers.add(newCustomer);

        return newCustomer;
    }

    /**
     * Add a new account to the list of accounts.
     * @param newAccount        the account to add
     */
    public void addNewAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    /**
     * Get the Customer object associated with a particular login data.
     * @param id            the provided ID number
     * @param password      the provided password
     * @return              the Customer object, if login data are correct, or null,
     *                      if they are not
     */
    public Customer checkLoginData(String id, String password) {

        for (Customer customer : customers) {
            if (id.compareTo(customer.getId()) == 0 && password.compareTo(customer.getPassword()) == 0) {
                return customer;
            }
        }
        return null;
    }
}
