import java.util.InputMismatchException;
import java.util.Scanner;

// Модель (Model)
public class CalculatorModel {
    private double result;

    public void add(double number1, double number2) {
        result = number1 + number2;
    }

    public double getResult() {
        return result;
    }
}

// Представление (View)
public class CalculatorView {
    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    public void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public double getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        double input = scanner.nextDouble();
        return input;
    }
}

// Презентер (Presenter)
public class CalculatorPresenter {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void onAddButtonClicked() {
        try {
            double number1 = view.getUserInput();
            double number2 = view.getUserInput();

            model.add(number1, number2);
            double result = model.getResult();

            view.displayResult(result);
        } catch (InputMismatchException e) {
            view.displayError("Некорректный ввод. Пожалуйста, введите числа.");
        } catch (ArithmeticException e) {
            view.displayError("Ошибка арифметической операции: " + e.getMessage());
        }
    }
}

// Главный класс приложения
public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorPresenter presenter = new CalculatorPresenter(model, view);

        boolean continueCalculation = true;

        while (continueCalculation) {
            presenter.onAddButtonClicked(); // Можно заменить на другие операции

            System.out.print("Хотите продолжить? (да/нет): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("да")) {
                continueCalculation = false;
            }
        }
    }
}
