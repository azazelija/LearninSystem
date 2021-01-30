package part1;

import java.util.Arrays;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 20:47
 * @project spring.mvc.tutorial.project
 */
public class EnumExamples {
    enum Months implements Runnable{ //неявно Comparator Serializable
        APRIL(1), MAY(2), JANUARY(3), MARCH(4);
        private int age;
        Months(int age){
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public void run() {
            System.out.println("ENUM MONTHS");
        }
    }

    public static void main(String[] args) {
        Months[] monthArray = Months.values(); //возвращает массив, содержащий все значения перечисления
        Arrays.stream(monthArray).forEach((m) -> System.out.println(m.getAge()));

        monthArray[0].run();
    }
}
