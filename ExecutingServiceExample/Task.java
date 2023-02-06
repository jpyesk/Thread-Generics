package ExecutingServiceExample;

public class Task implements Runnable{
    String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("My Task named as " +name+ " Has Started By Thread "+ Thread.currentThread().getId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("My Task named as " + name+" Has Finished By Thread "+ Thread.currentThread().getId());
    }
}
