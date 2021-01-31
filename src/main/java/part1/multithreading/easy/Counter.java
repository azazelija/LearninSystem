package part1.multithreading.easy;

/**
 * @author KRISTINA BRAVO
 * @created_at 31/01/2021 - 14:20
 */
class Counter {
    /*
     * Использование ключевого слова volatile гарантирует,
     * что все потоки всегда будут использовать общее, исходное значение,
     * и они будут видеть изменения этого исходного значения другими потоками сразу же
     */
    private volatile long counter = 0L; //операции чтения и записи полей всех типов, кроме long и double, являются атомарными.

    public synchronized void increaseCounter() { //монитор блокируется для одного потока
        counter++; //не атомарная операция
    }

    public long getCounter() {
        return counter;
    }
}
