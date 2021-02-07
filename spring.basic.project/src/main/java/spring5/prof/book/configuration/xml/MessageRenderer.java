package spring5.prof.book.configuration.xml;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:23
 */
public class MessageRenderer implements Renderer {
    @Override
    public void render() {
        System.out.println("XML Configuration");
    }
}
