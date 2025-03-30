import java.util.*;

public class Manager {
    private HashMap<String, Client> clients;
    private Set<Product> products;
    private Queue<Order> orders;

    public void init() {
        this.products.add(new Product("Keyboard 1", Product.Category.Peripheral));
        this.products.add(new Product("Keyboard 2", Product.Category.Peripheral));
    }

    public Set<Product> addProduct(String name, Product.Category category) {
        Product getProduct = this.getProduct(name, true);
        if (getProduct != null) throw new RuntimeException("Product exists");

        Product newProduct = new Product(name, category);
        this.products.add(newProduct);

        System.out.println("Product added: " + newProduct);
        return this.products;
    }

    public Product getProduct(String name, boolean exactly) {
        return this.products.stream().filter(prod -> exactly ? prod.getName().equals(name) : prod.getName().contains(name)).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product getProduct(String name) {
        return getProduct(name, false);
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public Set<Product> removeProduct(String name) {
        Product getProduct = this.getProduct(name, true);
        if (getProduct == null) throw new RuntimeException("Product not exists");

        this.products.remove(getProduct);

        System.out.println("Product removed: " + getProduct);
        return this.products;
    }
}
