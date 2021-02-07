package spring5.prof.book.configuration.javaconfig;

import lombok.Setter;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:56
 */
@Setter
public class Computer {
    Updater updater;

    public void update() {
        updater.update();
    }
}
