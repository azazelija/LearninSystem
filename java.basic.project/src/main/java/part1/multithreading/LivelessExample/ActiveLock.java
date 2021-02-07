package part1.multithreading.LivelessExample;

import part1.EnumExamples;

import java.util.ArrayDeque;
import java.util.Arrays;


/**
 * @author KRISTINA BRAVO
 * @created_at 31/01/2021 - 15:11
 */

/*
    Отличным примером livelock является система обмена сообщениями,
    в которой при возникновении исключения потребитель сообщения откатывает транзакцию
    и помещает сообщение обратно в начало очереди.
    Затем одно и то же сообщение многократно считывается из очереди только для того,
    чтобы вызвать еще одно исключение и быть помещенным обратно в очередь.
    Потребитель никогда не получит никакого другого сообщения из очереди.
 */
public class ActiveLock {

    static ArrayDeque<String> messages = new ArrayDeque<String>();

    public static void main(String[] args) {
        Arrays.stream(EnumExamples.Months.values()).forEach((m) -> messages.add(m.name()));
        messages.add("FALSE");

        Thread t1 = new Thread(() -> {
            while (messages.size() != 0) //сообщение крутится бесконечно
                activeLock(messages.pollFirst());
        });

        t1.start();
    }

    public static String activeLock(String message) {
        if (message.equals("FALSE")) {
            messages.addFirst(message); //сообщение возвращается обратно в начало очереди
        }
        System.out.println(message);
        return message;
    }
}
