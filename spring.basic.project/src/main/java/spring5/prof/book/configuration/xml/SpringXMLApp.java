package spring5.prof.book.configuration.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:26
 */
public class SpringXMLApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        Renderer mr = ctx.getBean("renderer", Renderer.class);
        mr.render();

        MessageProvider provider = ctx.getBean("provider", MessageProvider.class);
        provider.provide();
    }
}
