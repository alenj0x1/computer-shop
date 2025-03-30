public class Product {
    public enum Category {
        Audio,
        Peripheral,
        Accessory
    }
    private final String name;
    private final Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return "Product: " + this.name;
    }
}
