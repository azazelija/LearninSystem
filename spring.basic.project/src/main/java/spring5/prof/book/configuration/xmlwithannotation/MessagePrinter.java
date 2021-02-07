package spring5.prof.book.configuration.xmlwithannotation;

import org.springframework.stereotype.Component;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:41
 */

@Component
public class MessagePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("XML + Annotation config");
    }
}
