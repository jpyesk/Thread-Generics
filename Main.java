
class newThread implements Runnable{
//    Thread t;
    //    newThread(){
//        t = new Thread(this);
//        t.start();
//    }
//    newThread(String name){
//        t = new Thread(this,name);
//        t.start();
//    }
    @Override
    public void run() {
        for (int i = 5; i >0 ; i--) {
            try {
                System.out.println(Thread.currentThread() + " :" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            System.out.println(Thread.currentThread() + ": has Ended");
    }
}

public class Main {
    public static void main(String[] args) {
//        newThread t1 = new newThread();
//        newThread t2 = new newThread("second");
//        newThread t3 = new newThread();
// or u can delete the constructor in *newThread* class and create it inside the main ->
        Thread t1 = new Thread(new newThread());
        Thread t2 = new Thread(new newThread());
        Thread t3 = new Thread(new newThread());
        t1.setName("gOgson");
        t1.setPriority(1);
        t2.setPriority(10);
        t3.setPriority(5);
        t1.start();
        t2.start();
        t3.start();
        try { //In order for *main-thread*  to execute last
            t1.join();
            t2.join();
            t3.join();
            System.out.println(t1.isAlive());
            System.out.println(t2.isAlive());
            System.out.println(t3.isAlive());
            System.out.println(t1.getPriority());
            System.out.println(t2.getPriority());
            System.out.println("GG");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}