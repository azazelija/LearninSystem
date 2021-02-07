package spring5.prof.book.configuration.xmlwithannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:42
 */
public class SpringAnnotationApp {
    public static void main(String[] args) {
        ApplicationContext apx = new ClassPathXmlApplicationContext("app-context.xml");
        Printer printer = apx.getBean("messagePrinter", Printer.class);
        printer.print();
    }
}
