import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank theBank = new Bank("STBA");

        Customer verifiedCustomer;

        while (true) {
            signInUp(theBank);
            verifiedCustomer = signIn(theBank);
            printMainMenu(theBank, verifiedCustomer);
        }
    }
}
