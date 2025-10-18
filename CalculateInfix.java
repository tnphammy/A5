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
        // 1. Translate Infix expression to Postfix
        // TRANSLATION
        // Make relevant data structures
        Queue<Object> translatedQueue = new Queue<>(); 
        Stack<Object> stack = new Stack<>();
        boolean isOpen = false; // indicates whether a parenthesis has been opened
        // 1. Loop through tokens
        while(!tokens.isEmpty()) {
            Object token = tokens.remove();
            // NUMBER? -> Add straight to queue
            if (token instanceof Double) {
                translatedQueue.add(token);
            }
            // PARENTHESIS?
            else if (token.equals('(') || token.equals(')')) {
                // Case 1: Left parenthesis '('
                if (token.equals('(')) {
                    stack.push(token); // Add to stack
                    isOpen = true; // Know that an equation has been opened
                }
                // Case 2: Right parenthesis ')'
                else if (token.equals(')')) {
                    while ((!stack.isEmpty()) && (!stack.peek().equals('('))) {
                        // Pop operators off stack until reaches '('
                        translatedQueue.add(stack.pop());
                    }
                    // If '(' not found -> Alert mismatch
                    if (!isOpen) {
                        throw new IllegalArgumentException("There is a mismatched parenthesis.");
                    }
                    // Pop one more time to rid of '('
                    stack.pop();
                }
            }
            // OPERATOR?
            else if (token instanceof Character) {
                // Case 1: Stack is empty -> Just add to stack
                if (stack.isEmpty()) {
                    stack.push(token);
                }
                // Case 2: Needs comparison
                else {
                    // Feel free to stack on a '('
                    if (stack.peek().equals('(')) {
                        stack.push(token);
                    }
                    // Compare operators
                    else {
                        // while P(S) >= P(Q) -> pop P(S) into output
                        while (priorityLevel((Character)stack.peek()) > priorityLevel((Character)token)) {
                            translatedQueue.add(stack.pop());
                        }
                        // Add P(Q) to Stack
                        stack.push(token);
                    }
                }
            }
        }
        // Outside of loop:
        // Pop all operators in stack
        while (!stack.isEmpty()) {
            // Check: If there is a '(' left hanging -> Alert mismatch
            if (isOpen) {
                throw new IllegalArgumentException("There is a mismatched parenthesis.");
            }
            translatedQueue.add(stack.pop());
        }
        // 2. Calculate result from Postfix
        System.out.println("Translated:" + translatedQueue);
        Double finalResult = CalculatePostfix.postfixToResult(translatedQueue);
        return finalResult;
    }
}