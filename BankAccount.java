 class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    // Add money to account (e.g., after a buyer purchases an item)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs. " + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money from account (optional, may not be needed now)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew Rs. " + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
