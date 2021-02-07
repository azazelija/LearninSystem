package part1.multithreading.hight.level.api;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Комбинация IP-адреса (адрес компьютера) и порта (для определения приложения) называется сокетом или гнездом (socket)
 * http 80 https 443
 */
public class ExecutorExample {
    public static void main(String[] args) {
        try {
            NetworkService networkService = new NetworkService(5000, 10);
            new Thread(networkService).start();

            Client client = new Client("localhost", 5000);
            new Thread(client).start();
        }
        catch (IOException e) {
            System.out.println("Не удалось создать соединение");
            e.printStackTrace();
        }
    }

}

class NetworkService implements Runnable{
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
    }

    @Override
    public void run() { // run the service
        try {
            while (true)
                pool.execute(new Handler(serverSocket.accept()));
        } catch (IOException ex) {
            pool.shutdown();
        }
    }

    void shutdownAndAwaitTermination() {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

class Handler implements Runnable {
    private final Socket socket;

    Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client accepted");
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/java/part1/multithreading/hight/level/api/ClientMessages.txt"));) {
            String line = "";
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    writer.write(line + "\n");
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing handler socket connection");
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client implements Runnable{
    private Socket socket;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port); //создаем клиента на локале с портом 8000
    }

    @Override
    public void run() {
        try {
            System.out.println("Client Connected");
            input = new DataInputStream(System.in); //считываем с консоли
            out = new DataOutputStream(socket.getOutputStream()); //записываем
        } catch (IOException u) {
            System.out.println(u);
        }
        String line = ""; // string to read message from input
        while (!line.equals("Over")) { // keep reading until "Over" is input
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }
        try {
            System.out.println("Closing client socket connection");
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}


/**
 * Этот тип пула всегда держит работающими указанное количество потоков.
 * Если поток как-нибудь завершается в то время, пока он всё ещё используется,
 * то он автоматически заменяется вновь созданным потоком.
 * Задачи отправляются в пул через внутреннюю очередь, которая хранит дополнительные задачи, если их больше, чем потоков.
 * <p>
 * public static ExecutorService newFixedThreadPool(int nThreads)
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 * <p>
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 * <p>
 * public static ExecutorService newCachedThreadPool()
 * <p>
 * Пул потоков, состоящий из одного потока.
 * <p>
 * public static ExecutorService newSingleThreadExecutor()
 */

/**
 * Создаёт новые потоки по мере надобности. Повторно использует предыдущие потоки, если они свободны.
 *
 * public static ExecutorService newCachedThreadPool()
 */

/**
 * Пул потоков, состоящий из одного потока.
 *
 * public static ExecutorService newSingleThreadExecutor()
 */

/**
 * Класс-оболочка FutureTask представляет собой удобный механизм для превращения Callable
 * одновременно в Future и Runnable, реализуя оба интерфейса.
 */
