public class CalculateInfix {
    /**
     * Checks the priority level of an mathematic operator
     * based on PEMDAS
     * @param operator
     * @return a number (higher number - higher priority)
     */
    public static int priorityLevel(Character operator) {
        switch (operator) {
            case '-':
            case '+':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
            default:
                return 0;
        }
    }
    public static Double infixToPostfix(Queue<Object> tokens) {
        // FILL IN
    }
}