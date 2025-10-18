import java.util.NoSuchElementException;

public class CalculatePostfix {
    public static Double postfixToResult(Queue<Object> tokens) {
        // 0. Edge cases
        // The queue is null
        if (tokens == null) {
            throw new NoSuchElementException("Your equation is null.");
        }
        // The queue has no elements
        else if (tokens.isEmpty()) {
            return 0.0;
        }
        // 1. Create stack
        Stack<Double> calc = new Stack<>();
        // 2. Calculate by looping through queue
        while (!tokens.isEmpty()) {
            // Get the singular token
            Object token = tokens.remove();
            // if token is a number, push to the stack
            if (token instanceof Double) {
                calc.push((Double)token);
            }
            // if token is an operator, use on the previous 2 elements in stack
            else if (token instanceof Character) {
                Double first = 0.0;
                Double second = 0.0;
                // (1) pop stack to access 2nd element in equation - store it
                if (calc.isEmpty()) {
                    throw new IllegalArgumentException("There are no elements to operate on.");
                }
                else {
                    second = calc.pop();
                }
                // (2) pop stack to access 1st element in equation - store it
                if (calc.isEmpty()) {
                    throw new IllegalArgumentException("There are not enough elements to operate on.");
                }
                else {
                    first = calc.pop();
                }
                // Calculates
                Double result = 0.0;
                // Addition
                if (token.equals('+')) {
                    result = first + second;
                }
                // Subtraction
                else if (token.equals('-')) {
                    result = first - second;
                }
                // Multiplication
                else if (token.equals('*')) {
                    result = first * second;
                }
                // Division
                else if (token.equals('/')) {
                    result = first / second;
                }
                // Division (Modular)
                else if (token.equals('%')) {
                    result = first % second;
                }
                // Push result to stack
                calc.push(result);
            }

        }
        Double finalResult = calc.pop();
        // Outside of calculation
        // throw error if stack not currently empty (Too many elements)
        if (!calc.isEmpty()) {
            throw new IllegalArgumentException("The current operation has elements without an operator yoo.");
        }
        // 3. Return final result 
        return finalResult;
    }
}