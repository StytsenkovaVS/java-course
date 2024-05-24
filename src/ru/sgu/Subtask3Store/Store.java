package ru.sgu.Subtask3Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Store {
    private List<Product> products = new ArrayList<>();

    public synchronized void addProduct(Product product) {
        products.add(product);
        System.out.println("Появился новый товар");
    }

    public synchronized Product sellProduct() {
        if (!products.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(products.size());
            return products.remove(index);
        }
        return null;
    }
}
