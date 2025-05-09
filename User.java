// Abstract means this class cannot be directly created as an object
 abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String password;

    // Constructor: called when creating a Maker or Buyer
    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Common getter methods (you can add setters if needed)
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // This is an abstract method. Maker and Buyer will implement this in their own way.
    public abstract void showMenu();
}
