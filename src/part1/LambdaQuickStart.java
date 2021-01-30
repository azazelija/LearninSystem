package part1;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 19:40
 * @project spring.mvc.tutorial.project
 */
public class LambdaQuickStart {

    public static void main(String[] args) {
        //Обычный способ вызова функции
        MyRunnableClass person = new MyRunnableClass();
        person.run();

        //Anonymous Inner Class - создается внутренний класс
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run Anonymous Inner Class");
            }

            public void printName() { //можно добавить методы но зачем
                System.out.println("marina");
            }
        });
        thread.run();

        //LambdaExpression
        Thread thread2 = new Thread(() -> System.out.println("Run LambdaExpression"));
        thread2.run();
    }

    public static class MyRunnableClass implements Runnable{

        @Override
        public void run() {
            System.out.println("Run MyRunnableClass");
        }
    }
}
