package spring5.prof.book.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 20:16
 */

@Configuration
public class WalletConf {

    @Bean
    public Wallet singleWallet() {
        return new Wallet();
    }

    @Bean
    @Scope("prototype")
    public Wallet protoWallet() {
        return new Wallet();
    }
}
