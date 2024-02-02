import org.junit.Test;
import static org.junit.Assert.*;

public class PostfixCalculatorTest {

    @Test
    public void testEvaluateValidExpression() {
        PostfixCalculator calculator = new PostfixCalculator();

        // Test expressions with various operators
        assertEquals(5, calculator.evaluate("23+"));
        assertEquals(6, calculator.evaluate("32*1+"));
        assertEquals(4, calculator.evaluate("52*1-"));
        assertEquals(9, calculator.evaluate("23*4/"));
        assertEquals(7, calculator.evaluate("52*1-3+"));

        // Test expressions with multi-digit numbers
        assertEquals(12, calculator.evaluate("35*+"));
        assertEquals(15, calculator.evaluate("921*+"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInvalidCharacter() {
        PostfixCalculator calculator = new PostfixCalculator();
        calculator.evaluate("2a+");  // 'a' is an invalid character
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInsufficientOperands() {
        PostfixCalculator calculator = new PostfixCalculator();
        calculator.evaluate("23+*");  // '*' requires two operands, but there is only one
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateInvalidExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        calculator.evaluate("23*");  // Not enough operators for the operands
    }

    @Test(expected = ArithmeticException.class)
    public void testEvaluateDivisionByZero() {
        PostfixCalculator calculator = new PostfixCalculator();
        calculator.evaluate("20/0");  // Attempting to divide by zero
    }
}
