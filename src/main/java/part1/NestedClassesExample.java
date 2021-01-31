package part1;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 20:24
 * @project spring.mvc.tutorial.project
 */
public class NestedClassesExample {

    public class InnerClassExample {
        @Override
        public String toString() {
            return "InnerClassExample{}";
        }
    }

    public static class StaticNestedClass {
        @Override
        public String toString() {
            return "StaticNestedClass{}";
        }
    }

    public static void main(String[] args) {
        NestedClassesExample example = new NestedClassesExample(); //вызывается только при создании внешнего
        InnerClassExample innerClassExample = example.new InnerClassExample();
        System.out.println(innerClassExample);

        //не привязан к внешнему классу
        NestedClassesExample.StaticNestedClass staticNestedClass = new NestedClassesExample.StaticNestedClass();
        System.out.println(staticNestedClass);

        class MethodLocalInnerClass { //а зачем это нужно (не использовать бредятину)
            @Override public String toString() { return "methodLocalInnerClass{}";} }
        MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass();
        System.out.println(methodLocalInnerClass);

        Runnable runnableClass = new Runnable() { //не проще лямбды использовать если интерфейс функциональный
            @Override public void run() { System.out.println("Anonymous inner class"); } };
        runnableClass.run();
    }
}
