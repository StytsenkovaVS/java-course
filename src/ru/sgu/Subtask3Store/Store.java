package ru.sgu.Subtask3Store;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Store {
    private Product[] products;
    private int currentIndex;
    private Lock lock;

    public Store() {
        products = new Product[10];
        currentIndex = 0;
        lock = new ReentrantLock();
    }

    public void addProduct(Product product) {
        lock.lock();
        try {
            if (currentIndex < products.length) {
                products[currentIndex] = product;
                currentIndex++;
            }
        } finally {
            lock.unlock();
        }
    }

    public Product sellProduct() {
        lock.lock();
        try {
            if (currentIndex > 0) {
                currentIndex--;
                Product product = products[currentIndex];
                products[currentIndex] = null;
                return product;
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }
}
