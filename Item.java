 class Item {
    private String itemId;
    private String title;
    private String description;
    private double price;
    private Maker maker;

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
}