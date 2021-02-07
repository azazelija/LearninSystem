package spring5.prof.book.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 20:18
 */
public class AppContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext apx = new AnnotationConfigApplicationContext(WalletConf.class);
        Wallet singleWallet = apx.getBean("singleWallet", Wallet.class);
        Wallet protoWallet = apx.getBean("protoWallet", Wallet.class);

        singleWallet.appendMoney(new BigDecimal(15000));
        protoWallet.appendMoney(new BigDecimal(15000));

        singleWallet = apx.getBean("singleWallet", Wallet.class);
        protoWallet = apx.getBean("protoWallet", Wallet.class);

        singleWallet.appendMoney(new BigDecimal(15000));
        protoWallet.appendMoney(new BigDecimal(15000));

        System.out.println(singleWallet.getAvailableMoney()); //30000
        System.out.println(protoWallet.getAvailableMoney()); //15000

        apx.close();
    }
}
