import java.util.ArrayList;
import java.util.List;

class Item {
    private String itemId;
    private String title;
    private String description;
    private double price;
    private Maker maker;
    private List<Review> reviews = new ArrayList<>();


    public Item(String itemId, String title, String description, double price, Maker maker) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.maker = maker;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Maker getMaker() {
        return maker;
    }

    @Override
    public String toString() {
        return "[" + itemId + "] " + title + " - Rs. " + price + "\n  Description: " + description +
               "\n  Maker: " + maker.getName();
    }
    public void addReview(Review review) {
        reviews.add(review);
    }
    public void showReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews for this item yet.");
        } else {
            System.out.println("Reviews:");
            for (Review r : reviews) {
                System.out.println(r);
            }
        }
    }
    public List<Review> getReviews() {
        return reviews;
    }
    
    
}