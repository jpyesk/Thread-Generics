package SemaphoresExample;

import java.util.concurrent.Semaphore;

public class Resources implements Runnable{
    private Semaphore semaphore;
    private String name;

    public Resources(Semaphore semaphore, String name){
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Permit is Given to a " + name);
            Thread.sleep(2000);
            System.out.println(name + " has finished accessing ");
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
