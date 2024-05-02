package ru.sgu.Subtask3;

import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable {
    private ArrayBlockingQueue<String> queue;

    public Producer(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        String[] values = {
                "Яблоко 52",
                "Банан 105",
                "Морковь 41",
                "Сельдерей 16",
                "Яйцо 78",
                "Курица 239",
                "Рис 130",
                "Брокколи 34",
                "Лосось 208",
                "Овсянка 134"
        };

        try {
            for (String value : values){
                queue.put(value);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
