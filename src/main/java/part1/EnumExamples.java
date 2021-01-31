package part1;

import java.util.Arrays;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 20:47
 * @project spring.mvc.tutorial.project
 */
public class EnumExamples {
    public static void main(String[] args) {
        Months[] monthArray = Months.values(); //возвращает массив, содержащий все значения перечисления
        Arrays.stream(monthArray).forEach((m) -> System.out.println(m.getOrder()));

        monthArray[0].run();
    }

    public enum Months implements Runnable { //неявно Comparator Serializable
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11);

        private int order;

        Months(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        @Override
        public void run() {
            System.out.println("ENUM MONTHS");
        }
    }
}
