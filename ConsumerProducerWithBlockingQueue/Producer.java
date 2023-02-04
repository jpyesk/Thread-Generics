package ConsumerProducerWithBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    BlockingQueue<String> blockingqueue = null;
    public Producer(BlockingQueue<String> queue){
        this.blockingqueue = queue;
    }
    @Override
    public void run() {
        while (true){
            long tml = System.currentTimeMillis();
            try {
                this.blockingqueue.put(""+ tml);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
