package ExecutingServiceExampleWithCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<String> inputs = new ArrayList<>();
        inputs.add("first");
        inputs.add("second");
        inputs.add("third");
        inputs.add("fourth");
        inputs.add("fifth");
        List<Future<String>> outputs = new ArrayList<>();
        for (String input : inputs) {
            Future<String> futures = executorService.submit(new Task2(input));
            outputs.add(futures);
        }
        for(Future<String> k: outputs){
            try {
                System.out.println(k.get());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        executorService.shutdown();

    }
}
