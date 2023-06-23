import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank theBank = new Bank("Szymon's Bank");

        Customer verifiedCustomer;

        while (true) {
            signInUp(theBank);
            verifiedCustomer = signIn(theBank);
            printMainMenu(theBank, verifiedCustomer);
        }
    }

    /**
     * Print the menu where customer need to choose to sign in or sign up.
     * @param theBank       the bank where the customer wants to sign in/up
     */
    public static void signInUp(Bank theBank) {

        int choice;

        System.out.printf("\n\n * * * Welcome in %s * * *\n\n", theBank.getName());
        do {
            System.out.println("  1. Sign in");
            System.out.println("  2. Sign up");
            System.out.print("Select the option (1-2): ");

            choice = scanner.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice < 1 || choice > 2);

        switch (choice) {
            case 1 -> scanner.nextLine();
            case 2 -> signUp(theBank);
        }

        if (choice != 1) {
            signInUp(theBank);
        }
    }

    /**
     * Sign up a new customer of the bank.
     * @param theBank       the bank where the customer wants to sign up
     */
    public static void signUp(Bank theBank) {

        scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        theBank.addNewCustomer(firstName, lastName, password);
    }

    /**
     * Sign in the customer of the bank.
     * @param theBank       the bank where the customer wants to sign in
     * @return              the signed in customer
     */
    public static Customer signIn(Bank theBank) {

        Customer verifiedCustomer;
        String id;
        String password;

        do {
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            verifiedCustomer = theBank.checkLoginData(id, password);
            if (verifiedCustomer == null) {
                System.out.println("Invalid login data. Please try again.");
            }
        } while (verifiedCustomer == null);

        System.out.printf("""
                
                Successful sign-in.
                Hello %s %s!""", verifiedCustomer.getFirstName(), verifiedCustomer.getLastName());
        System.out.println();
        return verifiedCustomer;
    }

    /**
     * Print the main menu of the application.
     * @param theBank           the bank where the customer is signed in
     * @param theCustomer       the signed in customer
     */
    public static void printMainMenu(Bank theBank, Customer theCustomer) {

        int choice;
        theCustomer.printAccountsSummary();

        do {
            System.out.println("MAIN MENU");
            System.out.println("""
                      1. Create New Account
                      2. Transaction History
                      3. Deposit
                      4. Withdraw
                      5. Transfer
                      6. Sign out
                    """);

            choice = scanner.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1 -> createNewAccount(theBank, theCustomer);
            case 2 -> showTransHistory(theCustomer);
            case 3 -> depositFunds(theCustomer);
            case 4 -> withdrawFunds(theCustomer);
            case 5 -> transferFunds(theCustomer);
            case 6 -> scanner.nextLine();
        }

        if (choice != 6) {
            printMainMenu(theBank, theCustomer);
        }
    }

    /**
     * Create a new account for signed-in customer.
     * @param theBank           the bank where the customer is signed-in
     * @param theCustomer       the signed-in customer
     */
    public static void createNewAccount(Bank theBank, Customer theCustomer) {

        int choice;

        do {
            System.out.println("  1. Savings");
            System.out.println("  2. Checking");
            System.out.println("  3. Foreign Currency");
            System.out.print("Select the type of the account (1-3): ");

            choice = scanner.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1 -> {
                Account savingsAccount = new Account("Savings", "PLN", theCustomer, theBank);
                theBank.addNewAccount(savingsAccount);
                theCustomer.addNewAccount(savingsAccount);
            }
            case 2 -> {
                Account checkingAccount = new Account("Checking", "PLN", theCustomer, theBank);
                theBank.addNewAccount(checkingAccount);
                theCustomer.addNewAccount(checkingAccount);
            }
            case 3 -> createForeignCurrencyAccount(theBank, theCustomer);
        }
    }


    /**
     * Create a new foreign currency account for signed-in customer.
     * @param theBank           the bank where the customer is signed-in
     * @param theCustomer       the signed-in customer
     */
    public static void createForeignCurrencyAccount(Bank theBank, Customer theCustomer) {

        int choice;
        do {
            System.out.println("  1. USD");
            System.out.println("  2. EUR");
            System.out.print("Select the currency of the account (1-2): ");

            choice = scanner.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while(choice < 1 || choice > 2);

        switch (choice) {
            case 1 -> {
                Account USDAccount = new Account("Foreign Currency", "USD", theCustomer, theBank);
                theBank.addNewAccount(USDAccount);
                theCustomer.addNewAccount(USDAccount);
            }
            case 2 -> {
                Account EURAccount = new Account("Foreign Currency", "EUR", theCustomer, theBank);
                theBank.addNewAccount(EURAccount);
                theCustomer.addNewAccount(EURAccount);
            }
        }
    }

    /**
     * Show transaction history for the particular account of the customer
     * @param theCustomer       the signed-in customer
     */
    public static void showTransHistory(Customer theCustomer) {

        int acctIdx = selectAccount(theCustomer, "which transactions you want to see");
        theCustomer.printAcctTransHistory(acctIdx);
    }

    /**
     * Deposit funds in the particular account of the customer.
     * @param theCustomer       the signed-in customer
     */
    public static void depositFunds(Customer theCustomer) {

        int inAcct;
        double amount;
        String title;

        inAcct = selectAccount(theCustomer, "to deposit in");
        amount = selectAmount("deposit");

        System.out.print("Enter title: ");
        scanner.nextLine();
        title = scanner.nextLine();

        theCustomer.addAcctTransaction(inAcct, amount, title);
    }

    /**
     * Select the particular account of the customer for further actions.
     * @param theCustomer       the signed-in customer
     * @param action            the action that will be performed
     *                          on the selected account
     * @return                  the index of selected account
     */
    public static int selectAccount(Customer theCustomer, String action) {

        int acctIdx;

        do {
            System.out.printf("Select the account (1-%d) %s: ", theCustomer.numAccounts(), action);

            acctIdx = scanner.nextInt() - 1;
            if (acctIdx < 0 || acctIdx >= theCustomer.numAccounts()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (acctIdx < 0 || acctIdx >= theCustomer.numAccounts());

        return acctIdx;
    }

    /**
     * Select the amount of money for further actions.
     * @param action        the action that will be performed
     *                      on the selected amount of money
     * @return              the amount
     */
    public static double selectAmount(String action) {

        double amount;

        do {
            System.out.printf("Enter the amount to %s: ", action);

            amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
            }
        } while (amount <= 0);

        return amount;
    }

    /**
     * Withdraw funds from the particular account of the customer.
     * @param theCustomer       the signed-in customer
     */
    public static void withdrawFunds(Customer theCustomer) {

        int fromAcct;
        double amount;
        String title;
        boolean isAcctEmpty;

        do {
            fromAcct = selectAccount(theCustomer, "to withdraw from");
            isAcctEmpty = isAcctEmpty(theCustomer, fromAcct);
        } while (isAcctEmpty);

        amount = selectAmount(theCustomer, fromAcct, "withdraw");

        System.out.print("Enter title: ");
        scanner.nextLine();
        title = scanner.nextLine();

        theCustomer.addAcctTransaction(fromAcct, -1*amount, title);
    }

    /**
     * Check if the selected account of the customer is empty.
     * @param theCustomer       the signed-in customer
     * @param acctIdx           the index of the account to check
     * @return                  true if the account is empty, or false, if it is not
     */
    public static boolean isAcctEmpty(Customer theCustomer, int acctIdx) {

        if (theCustomer.getAccount(acctIdx).getBalance() == 0) {
            System.out.println("The balance of the selected account is zero.");
            System.out.println("Please select the other account.");
            return true;
        }
        return false;
    }

    /**
     * The overloaded selectAmount() method with balance condition.
     * @param theCustomer       the signed-in customer
     * @param fromAcct          the account from which amount is taken
     * @param action            the action that will be performed
     *                          on the selected amount of money
     * @return                  the amount
     */
    public static double selectAmount(Customer theCustomer, int fromAcct, String action) {

        double acctBal = theCustomer.getAcctBalance(fromAcct);
        double amount;

        Account theAcct = theCustomer.getAccount(fromAcct);

        do {
            System.out.printf("Enter the amount to %s (max %.02f%s): ", action, acctBal,
                    theAcct.getCurrency());

            amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than balance of %.02f%s.\n", acctBal,
                        theAcct.getCurrency());
            }
        } while (amount <= 0 || amount > acctBal);

        return amount;
    }
}
