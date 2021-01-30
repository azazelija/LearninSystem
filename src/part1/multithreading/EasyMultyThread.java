package part1.multithreading;

/**
 * @author KRISTINA BRAVO
 * @created_at 30/01/2021 - 21:53
 */
public class EasyMultyThread {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start(); //start() а не run()
        }
        Thread.sleep(1000);

        System.out.println("Counter:" + counter.getCounter());
    }
}

class Counter {
    /*
    Использование ключевого слова volatile гарантирует,
    *что все потоки всегда будут использовать общее, исходное значение,
    *и они будут видеть изменения этого исходного значения другими потоками сразу же
    */
    private volatile long counter = 0L; //операции чтения и записи полей всех типов, кроме long и double, являются атомарными.

    public synchronized void increaseCounter() { //монитор блокируется для одного потока
        counter++; //не атомарная операция
    }

    public long getCounter() {
        return counter;
    }
}

class CounterThread extends Thread { //Runnable, Callable
    private Counter counter;

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
