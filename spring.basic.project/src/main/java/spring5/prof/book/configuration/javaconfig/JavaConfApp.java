package spring5.prof.book.configuration.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:58
 */
public class JavaConfApp {
    public static void main(String[] args) {
        ApplicationContext apx = new AnnotationConfigApplicationContext(UpdaterConfiguration.class);
        Computer computer = apx.getBean("computer", Computer.class);
        computer.update();
    }
}
