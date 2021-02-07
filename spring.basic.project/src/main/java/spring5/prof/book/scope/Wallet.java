package spring5.prof.book.scope;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author KRISTINA BRAVO
 * @created_at 07/02/2021 - 19:36
 */
@Component
@NoArgsConstructor
@Getter
public class Wallet {
    private BigDecimal balance = BigDecimal.ZERO;

    public Wallet(BigDecimal balance) {
        this.balance = balance;
    }

    public void appendMoney(BigDecimal money) {
        balance = balance.add(money);
    }

    public String getAvailableMoney() {
        DecimalFormat formatTotal = new DecimalFormat("#,###.00 руб");
        return formatTotal.format(balance);
    }

    @PostConstruct
    private void postConstructor() {
        System.out.println("PostConstructor");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy");
    }
}
