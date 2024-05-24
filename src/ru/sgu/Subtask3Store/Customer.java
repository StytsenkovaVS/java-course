package ru.sgu.Subtask3Store;

class Customer extends Thread {
    private Store store;
    private String name;
    private int totalPrice;


    public Customer(Store store, String name) {
        this.store = store;
        this.name = name;
        this.totalPrice = 0;
    }

    @Override
    public void run() {
        Product product = store.sellProduct();
        if (product != null) {
            totalPrice += product.getPrice();
            System.out.println(name + " " + product.getName() + " " + product.getPrice() + "\n" + totalPrice);
        } else {
            System.out.println(name + " не нашёл товар.");
        }
    }
}