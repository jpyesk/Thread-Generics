package FutureANDCallable;

import java.util.Random;
import java.util.concurrent.Callable;

public class Service implements Callable<Integer> {
    int num;
    Service(int num){
        this.num = num;
    }
    @Override
    public synchronized Integer call() throws Exception {
        Thread.sleep(3000);
        int sum = 0;
        for (int i=0; i < num;i++){
            sum +=i;
        }
        return sum;
    }
}
