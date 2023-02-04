package ConsumerProducerWithBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        Producer producer1 = new Producer(blockingQueue);
//        Consumer consumer1 = new Consumer(blockingQueue);
//        Consumer consumer2 = new Consumer(blockingQueue);
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread1 = new Thread(new Consumer(blockingQueue));
        Thread consumerThread2 = new Thread(new Consumer(blockingQueue));
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

    }
}
