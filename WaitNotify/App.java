package WaitNotify;
class ThreadOne implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());


    }
}


public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadOne());
        Thread t3 = new Thread(new ThreadOne());
        t1.setName("frst");
        t2.setName("scnd");
        t3.setName("third");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        


        System.out.println("main thread ended");
    }
}
