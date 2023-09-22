import java.util.logging.Logger;

public class ComplexCalculator {
    /**
     *
     */
    private static final Logger logger = Logger.getPlatformLogger(ComplexCalculator.class);

    public static Logger getLogger() {
        return logger;
    }

    public static class ComplexNumber {
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public double getReal() {
            return real;
        }

        public double getImaginary() {
            return imaginary;
        }

        public ComplexNumber add(ComplexNumber other) {
            double newReal = this.real + other.getReal();
            double newImaginary = this.imaginary + other.getImaginary();
            return new ComplexNumber(newReal, newImaginary);
        }

        public ComplexNumber multiply(ComplexNumber other) {
            double newReal = this.real * other.getReal() - this.imaginary * other.getImaginary();
            double newImaginary = this.real * other.getImaginary() + this.imaginary * other.getReal();
            return new ComplexNumber(newReal, newImaginary);
        }

        public ComplexNumber divide(ComplexNumber other) {
            double divisor = other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary();
            double newReal = (this.real * other.getReal() + this.imaginary * other.getImaginary()) / divisor;
            double newImaginary = (this.imaginary * other.getReal() - this.real * other.getImaginary()) / divisor;
            return new ComplexNumber(newReal, newImaginary);
        }

        @Override
        public String toString() {
            return real + " + " + imaginary + "i";
        }
    }

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = num1.add(num2);
        logger.info("Adding " + num1 + " and " + num2 + " resulted in " + result);
        return result;
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = num1.multiply(num2);
        logger.info("Multiplying " + num1 + " and " + num2 + " resulted in " + result);
        return result;
    }

    /**
     * @param num1
     * @param num2
     * @return
     */
    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        if (num2.getReal() == 0 && num2.getImaginary() == 0) {
            ((Object) logger).error("Division by zero is not allowed.");
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        ComplexNumber result = num1.divide(num2);
        logger.info("Dividing " + num1 + " by " + num2 + " resulted in " + result);
        return result;
    }

    public static void main(String[] args) {
        ComplexCalculator calculator = new ComplexCalculator();
        ComplexNumber num1 = new ComplexNumber(3.0, 2.0);
        ComplexNumber num2 = new ComplexNumber(1.0, 4.0);

        ComplexNumber sum = calculator.add(num1, num2);
        ComplexNumber product = calculator.multiply(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
