import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Order {
    public enum Priority {
        Low,
        Medium,
        High
    }

    private final UUID id;
    private final Client client;
    private final ArrayList<ProductOrder> products;
    private final Priority priority;

    public Order(Client client, Priority priority) {
        this.id = UUID.randomUUID();
        this.client = client;
        this.products = new ArrayList<>();
        this.priority = priority;
    }

    public Client getClient() {
        return this.client;
    }

    public ArrayList<ProductOrder> getProducts() {
        return this.products;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public static Comparator<Order> PriorityComparator = (p1, p2) -> p1.getPriority().ordinal() - p2.getPriority().ordinal();

    @Override
    public String toString() {
        return "Order: " + this.id;
    }
}
