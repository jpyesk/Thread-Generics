package FutureANDCallable;

import ExecutingServiceExample.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        List<Future<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = exec.submit(new Service());
            lst.add(future);
        }
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = lst.get(i);
            try {
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
