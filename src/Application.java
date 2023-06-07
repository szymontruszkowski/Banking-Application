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
            case 1:
                scanner.nextLine();
                break;
            case 2:
                signUp(theBank);
                break;
        }

        if (choice != 1) {
            signInUp(theBank);
        }
    }
}
