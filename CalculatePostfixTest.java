public class CalculatePostfixTest {
    public static void main(String[] args) {
        Queue<Object> eq = Tokenizer.readTokens("");
        Double result = CalculateInfix.infixToPostfix(eq);
        System.out.println("Results: " + result);
    }
}
