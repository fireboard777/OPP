public class GenericMethodExample {
    // Обобщенный метод printElement
    public static <T> void printElement(T element) {
        System.out.println(element);
    }

    public static void main(String[] args) {
        Integer integer = 42;
        String string = "Hello, world!";
        Double doub = 3.14;

        // Вызываем обобщенный метод с разными типами данных
        printElement(integer); // Выведет: 42
        printElement(string);  // Выведет: Hello, world!
        printElement(doub);    // Выведет: 3.14
    }
}
