package part1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 15:39
 * @project spring.mvc.tutorial.project
 */
public class FunctionalInterfacesExample {

    Consumer consumer; //void accept(T var1); потребитель

    Supplier supplier; //T get(); поставщик

    Predicate predicate; //boolean test(T var1);

    Function function; //R apply(T var1); //приводит его к объекту типа R
}
