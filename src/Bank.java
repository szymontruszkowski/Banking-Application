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
        Random random = new Random();
        int length = 5;
        boolean nonUnique;

        do {

            id = "";
            for (int c = 0; c <= length; c++) {
                id += ((Integer)random.nextInt(10)).toString();
            }

            nonUnique = false;
            for (Customer c : customers) {
                if (id.compareTo(c.getID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return id;
    }
}
