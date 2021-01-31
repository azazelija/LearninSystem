package part1.multithreading.LivelessExample;

/**
 * @author KRISTINA BRAVO
 * @created_at 31/01/2021 - 14:23
 */
public class DeadLock {

    public static void main(String[] args) {
        final String res1 = "Recourse 1";
        final String res2 = "Recourse 2";

        // Пусть поток P1 навесит замок на ресурс res1, а затем на res2
        Thread P1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println("Поток 1 навесил замок на Ресурс 1");
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) { }

                synchronized (res2) { //ресурс занят 2 потоком
                    System.out.println("Поток 1 навесил замок на Ресурс 2");
                }
            }
        });

        // Поток P2 последовательно пытается запереть доступ к res2 и res1
        Thread P2 = new Thread(() -> {
            synchronized (res2) {
                System.out.println("Поток 2 навесил замок на Ресурс 2");
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) { }
                synchronized (res1) { //ресурс занят 1 потоком
                    System.out.println("Поток 2 навесил замок на Ресурс 1");
                }
            }
        });

        P1.start();
        P2.start();

    }
}