//package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Buyer extends User {
    private BankAccount bankAccount;
    private Cart cart = new Cart();
    private List<Order> orders = new ArrayList<>();
    private List<Maker> allMakers;


    public Buyer(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.bankAccount = new BankAccount();
    }

    public void viewAccountBalance() {
        System.out.println("Your current balance is: Rs. " + bankAccount.getBalance());
    }

    // This will be filled with product browsing logic soon
    
        public void browseProducts() {
            Scanner scanner = new Scanner(System.in);
            int choice;
        
            do {
                System.out.println("\n--- Browse Products ---");
                System.out.println("1. Browse by Maker");
                System.out.println("2. Browse by Category (coming soon)");
                System.out.println("3. Back");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
        
                if (choice == 1) {
                    System.out.println("\nAvailable Makers:");
                    for (int i = 0; i < allMakers.size(); i++) {
                        System.out.println((i + 1) + ". " + allMakers.get(i).getName());
                    }
        
                    System.out.print("Choose a maker (or 0 to cancel): ");
                    int mIndex = scanner.nextInt();
                    scanner.nextLine();
        
                    if (mIndex > 0 && mIndex <= allMakers.size()) {
                        Maker selected = allMakers.get(mIndex - 1);
                        List<Item> makerItems = selected.getItems();
        
                        for (int i = 0; i < makerItems.size(); i++) {
                            Item item = makerItems.get(i);
                            System.out.println((i + 1) + ". " + item.getTitle() + " - Rs. " + item.getPrice());
                        }
        
                        System.out.print("Select an item to (or 0 to go back): ");
                        int iIndex = scanner.nextInt();
                        scanner.nextLine();
        
                        if (iIndex > 0 && iIndex <= makerItems.size()) {
                            Item item = makerItems.get(iIndex - 1);
                            System.out.println("1. Add to Cart\n2. Buy Now\n3. Cancel");
                            int action = scanner.nextInt();
                            scanner.nextLine();
        
                            if (action == 1) cart.addItem(item);
                            else if (action == 2) placeOrder(item);
                        }
                    }
                } else if (choice == 2) {
                    System.out.println("Category browsing not implemented yet.");
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
                System.out.println("3. View Cart");
                System.out.println("4. Logout");
                System.out.println("5. Leave a Review");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
        
                switch (choice) {
                    case 1:
                        browseProducts();
                        System.out.println("Product browsing only available with maker list.");
                        break;
                    case 2:
                        viewAccountBalance();
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        System.out.println("Logging out...");
                        break;
                    case 5:
                        leaveReview();
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } while (choice != 4);
        }
        
    

    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public void placeOrder(Item item) {
        double price = item.getPrice();
    
        // Check if buyer has enough balance
        if (bankAccount.getBalance() < price) {
            System.out.println("Insufficient balance to place order.");
            return;
        }
    
        // Transfer money: Buyer → Maker
        bankAccount.withdraw(price);
        item.getMaker().getBankAccount().deposit(price);
    
        // Create Order
        String orderId = "O" + (orders.size() + 1);
        Order order = new Order(orderId, this, item);
        orders.add(order);
    
        // Show Receipt
        System.out.println(order.generateReceipt());
    }
    public void viewCart() {
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        do {
            cart.showCartItems();
    
            if (cart.isEmpty()) break;
    
            System.out.println("\nChoose an item to:");
            System.out.println("1. Buy Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
    
            if (choice == 1 || choice == 2) {
                System.out.print("Enter item number: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();
    
                if (index >= 0 && index < cart.getItems().size()) {
                    Item item = cart.getItems().get(index);
    
                    if (choice == 1) {
                        placeOrder(item);
                        cart.getItems().remove(item);
                    } else {
                        cart.removeItem(index);
                    }
                } else {
                    System.out.println("Invalid item number.");
                }
            }
    
        } while (choice != 3);
    }
    public void leaveReview() {
        Scanner scanner = new Scanner(System.in);
    
        if (orders.isEmpty()) {
            System.out.println("You haven't placed any orders yet.");
            return;
        }
    
        System.out.println("\n--- Your Orders ---");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.println((i + 1) + ". " + order.getItem().getTitle() +
                    " - Rs. " + order.getAmount() +
                    " (Maker: " + order.getItem().getMaker().getName() + ")");
        }
    
        System.out.print("Choose an order to review (or 0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        if (choice > 0 && choice <= orders.size()) {
            Order order = orders.get(choice - 1);
            Item item = order.getItem();
    
            System.out.print("Enter rating (1 to 5): ");
            int rating = scanner.nextInt();
            scanner.nextLine();
    
            System.out.print("Enter your comment: ");
            String comment = scanner.nextLine();
    
            String reviewId = "R" + (item.getReviews().size() + 1);
            Review review = new Review(reviewId, this, item, rating, comment);
            item.addReview(review);
    
            System.out.println("Thank you! Your review has been submitted.");
        }
    }
    public void setMakerList(List<Maker> makers) {
        this.allMakers = makers;
    }
    
}
