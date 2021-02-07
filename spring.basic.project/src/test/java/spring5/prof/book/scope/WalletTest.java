package spring5.prof.book.scope;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 20:01
 */
class WalletTest {
    Wallet wallet = new Wallet();

    @Test
    void appendMoneyTest() {
        wallet.appendMoney(new BigDecimal(15000));
        Assertions.assertEquals(15000L, wallet.getBalance().longValue());
    }

    @Test
    void getAvailableMoneyTest() {
        wallet.appendMoney(new BigDecimal("15000.30"));
        Assertions.assertEquals("15 000,30 руб", wallet.getAvailableMoney());
    }
}