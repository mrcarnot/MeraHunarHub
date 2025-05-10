import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Maker> makers = new ArrayList<>();
    private static List<Buyer> buyers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Welcome to HunarHub ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Thank you for using HunarHub!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    private static void registerUser() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Register as:\n1. Maker\n2. Buyer");
        int type = scanner.nextInt();
        scanner.nextLine();

        String userId = "U" + (makers.size() + buyers.size() + 1);

        if (type == 1) {
            Maker maker = new Maker(userId, name, email, password);
            makers.add(maker);
            System.out.println("Maker registered successfully!");
        } else if (type == 2) {
            Buyer buyer = new Buyer(userId, name, email, password);
            buyers.add(buyer);
            System.out.println("Buyer registered successfully!");
        } else {
            System.out.println("Invalid user type.");
        }
    }

    private static void loginUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Try Makers
        for (Maker maker : makers) {
            if (maker.getEmail().equals(email) && maker.checkPassword(password)) {
                System.out.println("Login successful! Welcome, Maker " + maker.getName());
                maker.showMenu();
                return;
            }
        }

        // Try Buyers
        for (Buyer buyer : buyers) {
            if (buyer.getEmail().equals(email) && buyer.checkPassword(password)) {
                System.out.println("Login successful! Welcome, Buyer " + buyer.getName());
                buyer.setMakerList(makers); // assign maker list
                buyer.showMenu();           // call showMenu with no parameters
                        return;
            }
        }

        System.out.println("Invalid email or password.");
    }
}
