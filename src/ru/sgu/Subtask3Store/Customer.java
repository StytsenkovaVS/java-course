package ru.sgu.Subtask3Store;

class Customer extends Thread {
    private String name;
    private Store store;
    private int totalPrice;
    private int m;

    public Customer(String name, Store store) {
        this.name = name;
        this.store = store;
        this.totalPrice = 0;
        this.m = 2;
    }

    public void run() {
        while (store.getProducts().size() > 0) {
            try {
                Thread.sleep(m * 1000);
                Product product = store.sellProduct();
                if (product != null) {
                    System.out.println(name + " " + product.getName() + " " + product.getPrice());
                    totalPrice += product.getPrice();
                    System.out.println(totalPrice);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}