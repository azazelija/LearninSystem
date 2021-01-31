package part1.multithreading.easy;

/**
 * @author KRISTINA BRAVO
 * @created_at 31/01/2021 - 14:19
 */
public class EasyMultyThread {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start(); //start() а не run()
            ct.join();
        }

        System.out.println("Counter:" + counter.getCounter());
    }
}
