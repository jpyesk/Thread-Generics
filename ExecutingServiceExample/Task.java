package ExecutingServiceExample;

public class Task implements Runnable{
    String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task named as " + name +" Has Finished");
    }
}
