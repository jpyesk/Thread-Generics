package ConsumerProducerWithBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> blockingqueue = null;
    public Consumer(BlockingQueue<String> queue){
        this.blockingqueue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String element = this.blockingqueue.take();
                String text = Thread.currentThread().getName() + " consumed " + element;
                System.out.println(text);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
