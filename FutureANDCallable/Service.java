package FutureANDCallable;

import java.util.Random;
import java.util.concurrent.Callable;

public class Service implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
