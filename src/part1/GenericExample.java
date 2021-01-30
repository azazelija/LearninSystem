package part1;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 18:55
 * @project spring.mvc.tutorial.project
 */
public class GenericExample {

    public static <T> void acceptIfNotNull(Consumer<T> consumer, T value) {
        if (consumer != null)
            consumer.accept(value);
    }

    public static <T> Supplier<T> getFirstElem(List<T> list) {
        return () -> list.get(0);
    }

    public static <T> void acceptIfTrue(Consumer<T> consumer, T value, Predicate<T> predicate) {
        if (predicate.test(value))
            consumer.accept(value);
    }

    public static <T> String getToString(T value) {
        Function<T, String> function = Object::toString;
        return function.apply(value);
    }

    public static void main(String[] args) {
        String message = "Message";
        acceptIfTrue(System.out::println, message, Objects::nonNull);
        System.out.println(getToString(1890));
    }
}
