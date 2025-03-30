public class ProductOrder extends Product {
    private final int count;

    public ProductOrder(String name, Category category, int count) {
        super(name, category);
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
