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
    public String getNewCustomerID() {

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
    public String getNewAccountID() {

        String id;
        Random rng = new Random();
        int length = 10;
        boolean nonUnique;

        do {

            id = "";
            for (int c = 0; c < length; c++) {
                id += ((Integer)rng.nextInt(10)).toString();
            }

            nonUnique = false;
            for (Account a : this.accounts) {
                if (id.compareTo(a.getID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return id;
    }

    /**
     * Get randomly generated ID number.
     * @param length    the length of ID number
     * @return          the ID number
     */
    private String getNewID(int length) {

        Random random = new Random();
        String id = "";

        for (int d = 0; d <= length; d++) {
            id += ((Integer)random.nextInt(10)).toString();
        }
        return id;
    }

    /**
     * Check if the ID is unique.
     * @param id        the ID number to be checked
     * @param holder    the holder of the ID number (customer or account)
     * @return          true, if the ID number is unique, or false, if it is not
     */
    private boolean isUnique(String id, String holder) {

        switch (holder) {
            case "customer":
            for (Customer c : customers) {
                if (id.compareTo(c.getID()) == 0) {
                    return false;
                }
            }

            case "account":
            for (Account a : accounts) {
                if (id.compareTo(a.getID()) == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
