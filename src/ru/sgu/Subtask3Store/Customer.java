package ru.sgu.Subtask3Store;

class Customer extends Thread {
    private Store store;
    private String name;
    private int totalPrice;
    private int M;


    public Customer(Store store, String name) {
        this.store = store;
        this.name = name;
        this.totalPrice = 0;
        this.M = 3000;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(M);
                Product product = store.sellProduct();
                if (product != null) {
                    totalPrice += product.getPrice();
                    System.out.println(name + " " + product.getName() + " " + product.getPrice() + "\n" + totalPrice);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}