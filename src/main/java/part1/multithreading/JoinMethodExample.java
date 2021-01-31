package part1.multithreading;

import part1.EnumExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author KRISTINA BRAVO
 * @created_at 31/01/2021 - 13:57
 */
public class JoinMethodExample {

    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private static class MessageLoop implements Runnable {
        public void run() {
            List<String> month = new ArrayList<>();
            Arrays.stream(EnumExamples.Months.values()).forEach((m) -> month.add(m.name()));

            try {
                for (int i = 0; i < month.size(); i++) {
                    // Ждём 4 секунды
                    Thread.sleep(1000);
                    // Пишем сообщение
                    threadMessage(month.get(i));
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " closed");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        threadMessage("Starting MessageLoop thread");
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // ждём пока MessageLoop существует
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Ждём максимум 1 секунду завершения потока MessageLoop
            t.join(1000); //ставим main на блок до тех пор пока t не закончит работу
        }
        threadMessage("Finally!");
    }

}
