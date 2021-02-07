package spring5.prof.book.configuration.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 18:53
 */

@Configuration
public class UpdaterConfiguration {
    @Bean
    public Updater updater() {
        return new MessageUpdater();
    }

    @Bean
    public Computer computer() {
        Computer computer = new Computer();
        computer.setUpdater(updater());
        return computer;
    }
}
