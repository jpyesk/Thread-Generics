package FutureANDCallable;

import ExecutingServiceExample.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Integer>> lst = new ArrayList<>();
        for (int i = 1; i <10 ; i++) {
            Future<Integer> future = executor.submit(new Service(i));
            lst.add(future);
        }
        for(Future f: lst) {
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
