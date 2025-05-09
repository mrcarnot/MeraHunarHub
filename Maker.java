import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 class Maker extends User {
    private List<Item> items;
    private BankAccount bankAccount;

    public Maker(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.items = new ArrayList<>();
        this.bankAccount = new BankAccount();
    }

    // Add product
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully.");
    }

    // View all products added by this maker
    public void viewMyItems() {
        if (items.isEmpty()) {
            System.out.println("You have not added any items yet.");
        } else {
            System.out.println("Your Items:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    // View account balance
    public void viewAccountBalance() {
        System.out.println("Current Balance: Rs. " + bankAccount.getBalance());
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Maker Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. View My Products");
            System.out.println("3. View Account Balance");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter item description: ");
                    String desc = scanner.nextLine();

                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    String itemId = "I" + (items.size() + 1); // simple ID generation
                    Item item = new Item(itemId, title, desc, price, this);
                    addItem(item);
                    break;

                case 2:
                    viewMyItems();
                    break;

                case 3:
                    viewAccountBalance();
                    break;

                case 4:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public List<Item> getItems() {
        return items;
    }
}

