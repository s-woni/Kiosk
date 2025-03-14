package level6;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void printCart() {
        if (!items.isEmpty()) {
            System.out.println("\n                                 [ YOUR CART ]");
            for (MenuItem item : items) {
                item.printMenu();
            }
            System.out.println("\n                                [ TOTAL ]");
            System.out.println("$ " + calculateTotal() + "\n");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getMenuPrice();
        }
        return total;
    }
}
