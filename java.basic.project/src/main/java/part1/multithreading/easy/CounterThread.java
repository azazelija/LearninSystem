package part1.multithreading.easy;

/**
 * @author KRISTINA BRAVO
 * @created_at 31/01/2021 - 14:20
 */
class CounterThread extends Thread { //Runnable, Callable

    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
        }
    }
}
