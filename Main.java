//package app;

//mport models.*;

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
                    System.out.println("Thank you for visiting HunarHub!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    private static void registerUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Select role: 1. Maker  2. Buyer");
        int role = scanner.nextInt();
        scanner.nextLine();

        String userId = "U" + (makers.size() + buyers.size() + 1);

        if (role == 1) {
            Maker maker = new Maker(userId, name, email, password);
            makers.add(maker);
            System.out.println("Maker registered successfully!");
        } else if (role == 2) {
            Buyer buyer = new Buyer(userId, name, email, password);
            buyers.add(buyer);
            System.out.println("Buyer registered successfully!");
        } else {
            System.out.println("Invalid role.");
        }
    }

    private static void loginUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Search in Makers
        for (Maker maker : makers) {
            if (maker.getEmail().equals(email) && maker.checkPassword(password)) {
                System.out.println("Login successful! Welcome, " + maker.getName());
                maker.showMenu(); // run Maker menu
                return;
            }
        }

        // Search in Buyers
        for (Buyer buyer : buyers) {
            if (buyer.getEmail().equals(email) && buyer.checkPassword(password)) {
                System.out.println("Login successful! Welcome, " + buyer.getName());

                // Inject list of makers into browse menu
                int choice;
                do {
                    System.out.println("\n--- Buyer Menu ---");
                    System.out.println("1. Browse Products");
                    System.out.println("2. View Account Balance");
                    System.out.println("3. Logout");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            buyer.browseProducts(makers);
                            break;
                        case 2:
                            buyer.viewAccountBalance();
                            break;
                        case 3:
                            System.out.println("Logging out...");
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }

                } while (choice != 3);

                return;
            }
        }

        System.out.println("Invalid email or password.");
    }
}
