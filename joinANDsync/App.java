package joinANDsync;

class Mythread implements Runnable {
    private int cnt;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this){
                cnt++;
           }
        }
    }

    public int getCount() {
        return cnt;
    }
}


public class App {
    public static int count = 0;
    public static void main(String[] args) {
        Mythread first = new Mythread();
        Thread t1 = new Thread(first);
        Thread t2 = new Thread(first);
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
        try {
            t1.join();
            System.out.println("thread 1 started: ");
            t2.join();
            System.out.println("thread 2 started: ");
        } catch (InterruptedException e) {
        }
        System.out.println("main has ended ");
        System.out.println(first.getCount());
        
        
        
        System.out.println("First way of Threads ended: ");
        System.out.println("Starting the Anonymous Threads: ");
// thread's are on same object and that's why the count is also 20000
        Object syncobject = new Object();
        Thread otherway1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (syncobject) {
                    count++;
                }
            }
        });
      Thread otherway2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (syncobject) {
                        count++;
                    }
                }
            }
        });
        otherway1.start();
        otherway2.start();
        try {
            otherway1.join();
            otherway2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }
}
