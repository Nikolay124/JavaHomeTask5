import java.util.HashMap;
import java.util.Map;

public class BasketManager {
    private Map<String, Integer> basket = new HashMap<>();

    public void addProduct(String product, int quantity) {
        basket.put(product, basket.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(String product) {
        if (basket.containsKey(product)) {
            basket.remove(product);
        }
    }

    public void updateQuantity(String product, int quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, quantity);
        }
    }

    public int checkProduct(String product) {
        return basket.getOrDefault(product, 0);
    }

    public void showBasket() {
        for (var entry : basket.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BasketManager manager = new BasketManager();

        manager.addProduct("Apple", 5);
        manager.addProduct("Orange", 3);
        manager.addProduct("Banana", 10);

        System.out.println("Initial state of the basket:");
        manager.showBasket();

        manager.updateQuantity("Apple", 2);
        manager.removeProduct("Orange");

        System.out.println("\nUpdated state of the basket:");
        manager.showBasket();

        System.out.println("\nCheck products in the basket:");
        System.out.println("Apples: " + manager.checkProduct("Apple"));
        System.out.println("Oranges: " + manager.checkProduct("Orange"));
        System.out.println("Bananas: " + manager.checkProduct("Banana"));
    }
}