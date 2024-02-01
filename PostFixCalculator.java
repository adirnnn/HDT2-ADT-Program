public class PostfixCalculator {
    public int evaluate(String expression) {
        StackInterface<Integer> stack = new ArrayStack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for operation");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperation(c, operand1, operand2);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int applyOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}