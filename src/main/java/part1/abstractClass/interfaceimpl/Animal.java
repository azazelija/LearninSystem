package part1.abstractClass.interfaceimpl;

/**
 * @author 18395435
 * @created_at 30/01/2021 - 21:19
 *
 * Абстрактный класс — это «заготовка» класса:
 * реализовано большинство методов (включая внутренние), кроме нескольких.
 * Абстрактный класс — средство для повторного использования кода,
 * средство, чтобы указать, какой метод обязан быть перекрыт для завершения написания класса.
 * Абстрактный класс отвечает на вопрос "что чем является"
 */
public abstract class Animal {
    public void sleep() {
        System.out.println("Sleep");
    }

    public void eat() {
        System.out.println("Eat");
    }

    public void poop() {
        System.out.println("Poop");
    }

    public abstract void talk();
}
