//package models;

import java.util.List;
import java.util.Scanner;

 class Buyer extends User {
    private BankAccount bankAccount;

    public Buyer(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.bankAccount = new BankAccount();
    }

    public void viewAccountBalance() {
        System.out.println("Your current balance is: Rs. " + bankAccount.getBalance());
    }

    // This will be filled with product browsing logic soon
    public void browseProducts(List<Maker> allMakers) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Browse Products ---");
            System.out.println("1. Browse by Maker");
            System.out.println("2. Browse by Category (Coming Soon)");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Makers:");
                    for (int i = 0; i < allMakers.size(); i++) {
                        System.out.println((i + 1) + ". " + allMakers.get(i).getName());
                    }
                    System.out.print("Select a maker (or 0 to cancel): ");
                    int makerChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (makerChoice > 0 && makerChoice <= allMakers.size()) {
                        Maker selectedMaker = allMakers.get(makerChoice - 1);
                        List<Item> makerItems = selectedMaker.getItems();

                        if (makerItems.isEmpty()) {
                            System.out.println("This maker has no items.");
                        } else {
                            System.out.println("Items from " + selectedMaker.getName() + ":");
                            for (Item item : makerItems) {
                                System.out.println(item);
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("Category browsing not implemented yet.");
                    break;

                case 3:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
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
                    // You will pass the list of all Makers when calling showMenu from Main
                    System.out.println("Product browsing only available with maker list.");
                    break;

                case 2:
                    viewAccountBalance();
                    break;

                case 3:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
