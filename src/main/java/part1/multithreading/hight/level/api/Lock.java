package part1.multithreading.hight.level.api;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock: Это базовый интерфейс в Lock API. Он обеспечивает все функции ключевого слова synchronized,
 * добавляя новые методы для удобной работы.
 * Например:
 * метод lock() используется для того, чтобы получить lock для работы;
 * метод unlock() — освободить lock;
 * метод tryLock() для ожидания лока на протяжении определенного времени;
 * метод newCondition() — создать Condition и т.п.
 *
 * Не дай бог такое увижу в коде
 */
public class Lock {
    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        for (int i = 1; i < 6; i++) {

            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class CommonResource {

    int x = 0;
}

class CountThread implements Runnable {

    CommonResource res;
    ReentrantLock locker;

    CountThread(CommonResource res, ReentrantLock lock) {
        this.res = res;
        locker = lock;
    }

    public void run() {

        locker.lock(); // устанавливаем блокировку на блок
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}