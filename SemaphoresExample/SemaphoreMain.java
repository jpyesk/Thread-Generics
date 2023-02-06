package SemaphoresExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // or u can give it to two
        ExecutorService executorService =  Executors.newFixedThreadPool(3);
        List<String> names = new ArrayList<>();
        names.add("first");
        names.add("second");
        names.add("third");
        names.add("fourth");
        names.add("fifth");
        for(String k : names){
            executorService.execute(new Resources(semaphore,k));
        }
        executorService.shutdown();

    }
}
