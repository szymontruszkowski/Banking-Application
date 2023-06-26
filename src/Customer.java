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

    /**
     * Get the first name of the customer.
     * @return      the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name of the customer.
     * @return      the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Print the summary line for each customer's account.
     */
    public void printAccountsSummary() {

        System.out.printf("\n%s's accounts summary:\n", firstName);

        int i = 1;

        for(Account a : accounts) {
            System.out.printf("%d) %s\n", i++, a.getSummaryLine());
        }
        System.out.println();
    }

    /**
     * Get the number of accounts of this customer.
     * @return      the number of accounts
     */
    public int numAccounts() {
        return accounts.size();
    }

    /**
     * Call the printTransHistory() method for the particular account of this customer.
     * @param acctIdx       the index of the account
     */
    public void printAcctTransHistory(int acctIdx) {
        accounts.get(acctIdx).printTransHistory();
    }

    /**
     * Add the transaction for the particular account of the customer.
     * @param acctIdx       the index of the account
     * @param amount        the amount of the transaction
     * @param title         the title of the transaction
     */
    public void addAcctTransaction(int acctIdx, double amount, String title) {
        accounts.get(acctIdx).addTransaction(amount, title);
    }

    /**
     * Get the particular account of the customer.
     * @param acctIdx       the index of the account
     * @return              the account
     */
    public Account getAccount(int acctIdx) {
        return accounts.get(acctIdx);
    }

    /**
     * Get the balance of the particular account of the customer.
     * @param acctIdx       the index of the account
     * @return              the balance
     */
    public double getAcctBalance(int acctIdx) {
        return accounts.get(acctIdx).getBalance();
    }

    /**
     * Compare the currency of two selected accounts.
     * @param acctIdx1      the index of the first account
     * @param acctIdx2      the index of the second account
     * @return              true, if the currency is not the same, or false, if it is
     */
    public boolean notSameCurrency(int acctIdx1, int acctIdx2) {
        return !accounts.get(acctIdx1).getCurrency().equalsIgnoreCase(accounts.get(acctIdx2).getCurrency());
    }

    /**
     * Get the ID number of the particular account of the customer.
     * @param acctIdx       the index of the account
     * @return              the ID number
     */
    public String getAcctId(int acctIdx) {
        return accounts.get(acctIdx).getId();
    }

    public boolean isAccountsListEmpty() {

        if(accounts.size() == 0) {
            System.out.println("You don't have an account yet.");
            System.out.println("Follow the instructions below to create one.");
            return true;
        }
        return false;
    }
}
