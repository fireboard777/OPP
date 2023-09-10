public class GenericMethodExample {
    // Обобщенный метод для вывода элементов массива на консоль
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Создаем массивы типов Integer и String
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] strArray = { "Привет", "Мир", "Обобщенные", "Методы" };

        // Вызываем обобщенный метод printArray для каждого массива
        System.out.println("Массив целых чисел:");
        printArray(intArray);

        System.out.println("Массив строк:");
        printArray(strArray);
    }
}
