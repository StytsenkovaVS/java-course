package ru.sgu.Subtask3Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product sellProduct() {
        if (products.size() > 0) {
            Random rand = new Random();
            int index = rand.nextInt(products.size());
            return products.remove(index);
        } else {
            return null;
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}