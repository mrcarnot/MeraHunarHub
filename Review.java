public class Review {
    private String reviewId;
    private Buyer reviewer;
    private Item item;
    private int rating;
    private String comment;

    public Review(String reviewId, Buyer reviewer, Item item, int rating, String comment) {
        this.reviewId = reviewId;
        this.reviewer = reviewer;
        this.item = item;
        this.rating = rating;
        this.comment = comment;
    }

    public String toString() {
        return "Review by " + reviewer.getName() + " | Rating: " + rating + "/5\nComment: " + comment;
    }
}
