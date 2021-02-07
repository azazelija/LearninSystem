package spring5.prof.book.configuration.xml;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 19:20
 */
public class MessageProvider {
    @Autowired
    Renderer renderer;

    public void provide() {
        renderer.render();
    }
}
