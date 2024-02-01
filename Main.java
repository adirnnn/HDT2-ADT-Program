import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String expression = reader.readLine();
            reader.close();

            if (expression == null) {
                System.out.println("No hay expresión para evaluar.");
                return;
            }

            PostfixCalculator calculator = new PostfixCalculator();
            int result = calculator.evaluate(expression);
            System.out.println("El resultado de la expresión es: " + result);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}