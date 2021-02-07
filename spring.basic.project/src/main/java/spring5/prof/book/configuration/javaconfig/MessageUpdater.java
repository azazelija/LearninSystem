package spring5.prof.book.configuration.javaconfig;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:51
 */
public class MessageUpdater implements Updater {
    @Override
    public void update() {
        System.out.println("JavaConfig");
    }
}
