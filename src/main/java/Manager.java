import java.util.*;

public class Manager {
    private HashMap<String, Client> clients;
    private Set<Product> products;
    private Queue<Order> orders;

    public Manager() {
        this.clients = new HashMap<>();
        this.products = new HashSet<>();
        this.orders = new PriorityQueue<>(Order.PriorityComparator);
    }

    public  void addProduct(String name, Product.Category category) {
        Product getProduct = this.getProduct(name, true);
        if (getProduct != null) throw new RuntimeException("Product exists");

        Product newProduct = new Product(name, category);
        this.products.add(newProduct);

        System.out.println("Product added: " + newProduct);
    }

    public Product getProduct(String name, boolean exactly) {
        return this.products.stream().filter(prod -> exactly ? prod.getName().equals(name) : prod.getName().contains(name)).findFirst().orElse(null);
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
