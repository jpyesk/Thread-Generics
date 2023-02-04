package Bistro;

public class Bistro {
    private int seats;
    private Thread order,meal,waiter;

    public Bistro(int n){
        this.seats = n;
        this.order = null;
        this.meal = null;
        this.waiter = new Thread(this::serve);
        waiter.start();
    }

    synchronized void dine(int price){
        while (seats == 0){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        seats--;
        while (order != null){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        long ID = Thread.currentThread().getId();
        System.out.println("Guest "+ ID + " orders for " + price +" Lari");
        order = Thread.currentThread();
        notifyAll();
        while (meal !=Thread.currentThread()){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Guest "+ID +" eats");
        meal = null;
        seats++;
        notifyAll();
        Thread.currentThread().interrupt();
    }
    synchronized void serve(){
        while (order == null){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        Thread temp = order;
        order = null;
        notifyAll();
        while (meal != null){
            try {
                wait();
            } catch (InterruptedException e) {}
            meal = temp;
            System.out.println("Enjoy!");
            notifyAll();
        }
    }
    public void shutdown() {
        waiter.interrupt();
    }
}