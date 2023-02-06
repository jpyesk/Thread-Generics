package ExecutingServiceExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        String[] arr = new String[]{"first","second","third","fourth","fifth"};
        for (int i = 0; i <arr.length ; i++) {
            exec.execute(new Task(arr[i]));
        }
        exec.shutdown();
    }
}
