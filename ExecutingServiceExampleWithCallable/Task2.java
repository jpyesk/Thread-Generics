package ExecutingServiceExampleWithCallable;

import java.util.concurrent.Callable;

public class Task2 implements Callable<String> {
    String name;

    Task2(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        String answer = name.toUpperCase();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ("My Task named as " + name+ " Was formatted to uppercase and now it is: "+ answer +". P.S, Task was done By : "+ Thread.currentThread().getId());

    }
}
